package com.htdf.ma.mq.listener;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.JobListener;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class MyJobListener implements JobListener{

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Override
	public String getName() {
		return "jobListener";
	}

	@Override
	public void jobToBeExecuted(JobExecutionContext context) {
		//logger.info("{}任务开始执行。",context.getMergedJobDataMap().get("message"));
	}

	@Override
	public void jobExecutionVetoed(JobExecutionContext context) {
		logger.info("{}任务执行被禁止。",context.getMergedJobDataMap().get("message"));
		
	}

	@Override
	public void jobWasExecuted(JobExecutionContext context, JobExecutionException jobException) {
		logger.info("{}任务执行结束,消息已发送。",context.getMergedJobDataMap().get("message"));
	}
}
