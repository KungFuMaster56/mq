package com.htdf.ma.mq.service.Impl;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.htdf.ma.mq.job.QuartzJobFactory;
import com.htdf.ma.mq.listener.MyJobListener;
import com.htdf.ma.mq.listener.MyschedulerListener;
import com.htdf.ma.mq.listener.MytriggerListener;
import com.htdf.ma.mq.mapper.QuartzTaskMapper;
import com.htdf.ma.mq.pojo.QuartzTask;
import com.htdf.ma.mq.service.SchedulerService;
@Service
public class SchedulerServiceImpl implements SchedulerService{
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Resource
	private StdSchedulerFactory schedulerBean;
	
	@Resource
	private QuartzTaskMapper taskMapper;
	
	@Resource
	private MyJobListener jobListener;
	
	@Resource
	private MytriggerListener triggerListener;
	
	@Resource
	private MyschedulerListener schedulerListener;
	
	/**
	 * 
	 * @Title:restTaskStatus
	 * @Description:启动恢复开关状态 OFF
	 */
	@PostConstruct
	public void restTaskStatus(){
		taskMapper.taskOFF();
		try {
			Scheduler scheduler = schedulerBean.getScheduler();
			scheduler.getListenerManager().addJobListener(jobListener);
			//scheduler.getListenerManager().addTriggerListener(triggerListener);
			scheduler.getListenerManager().addSchedulerListener(schedulerListener);
		} catch (SchedulerException e) {
			logger.error("初始化监听器失败{}",e.getMessage());
		}
	}

	@Override
	public String addScheduler(QuartzTask qt) {
		try {
			Scheduler scheduler = schedulerBean.getScheduler();
			this.schedulerJob(scheduler, qt);
			taskMapper.update(qt);
		} catch (SchedulerException e) {
			e.printStackTrace();
			return "启动失败";
		}
		return "启动成功";
	}

	@Override
	public String delScheduler(QuartzTask qt) {
		try {
			Scheduler scheduler = schedulerBean.getScheduler();
			JobKey jobKey = new JobKey(qt.getTask_key(),qt.getGroup_key());
			scheduler.deleteJob(jobKey);
			taskMapper.update(qt);
		} catch (SchedulerException e) {
			e.printStackTrace();
			return "删除失败";
		}
		return "删除成功";
	}

	@Override
	public String resumeScheduler(QuartzTask qt) {
		try {
			Scheduler scheduler = schedulerBean.getScheduler();
			JobKey jobKey = new JobKey(qt.getTask_key(),qt.getGroup_key());
			scheduler.deleteJob(jobKey);
			this.schedulerJob(scheduler, qt);
			taskMapper.update(qt);
		} catch (SchedulerException e) {
			e.printStackTrace();
			return "重启失败";
		}
		return "重启成功";
	}
	
	private void schedulerJob(Scheduler scheduler,QuartzTask qt) throws SchedulerException{
		JobKey jk = new JobKey(qt.getTask_key(),qt.getGroup_key());
		JobDetail jd = JobBuilder.newJob(QuartzJobFactory.class).withIdentity(jk).build();
		jd.getJobDataMap().put("message", qt.getMessage());
		jd.getJobDataMap().put("onoff", qt.getOnoff());
		TriggerKey tk = new TriggerKey(qt.getTrigger_key(),qt.getGroup_key());
		Trigger trigger = TriggerBuilder.newTrigger().withIdentity(tk)
				.withSchedule(CronScheduleBuilder.cronSchedule(qt.getCron().trim())).build();
		scheduler.start();
		scheduler.scheduleJob(jd, trigger);
		if(qt.isImmediately()){
			scheduler.triggerJob(jk,jd.getJobDataMap());//添加任务，立即执行
		}
	}
}
