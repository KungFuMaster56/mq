package com.htdf.ma.mq.service;

import com.htdf.ma.mq.pojo.QuartzTask;

public interface SchedulerService {
	/**
	 * 
	 * @Title: addScheduler 
	 * @Description: 增加定时任务
	 * @param qt
	 * @return
	 * @return: String
	 */
	String addScheduler(QuartzTask qt);
	
	/**
	 * 
	 * @Title: delScheduler 
	 * @Description: 删除定时任务
	 * @param qt
	 * @return
	 * @return: String
	 */
	String delScheduler(QuartzTask qt);
	
	/**
	 * 
	 * @Title: resumeScheduler 
	 * @Description: 重启定时任务
	 * @param qt
	 * @return
	 * @return: String
	 */
	String resumeScheduler(QuartzTask qt);
	
	
}
