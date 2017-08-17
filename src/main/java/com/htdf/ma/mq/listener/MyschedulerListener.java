package com.htdf.ma.mq.listener;

import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.listeners.SchedulerListenerSupport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class MyschedulerListener extends SchedulerListenerSupport{
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	public void jobAdded(JobDetail jobDetail) {
		 logger.info("{}调度任务已添加。",jobDetail.getKey());
	}

	 public void jobDeleted(JobKey jobKey) {
		 logger.info("{}调度任务已删除。",jobKey);
	 }
}
