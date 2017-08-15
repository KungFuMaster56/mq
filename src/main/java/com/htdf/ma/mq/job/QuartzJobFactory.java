package com.htdf.ma.mq.job;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQTopic;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.htdf.ma.mq.service.NoticeService;
@DisallowConcurrentExecution
public class QuartzJobFactory implements Job{
	
	@Resource
	private NoticeService noticeService;

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String message = context.getMergedJobDataMap().getString("message");
		String topic = context.getMergedJobDataMap().getString("topic");
		String onoff = context.getMergedJobDataMap().getString("onoff");
		Destination destination = new ActiveMQTopic(topic);
		noticeService.sendMessage(destination, message+"&"+onoff);
	}
}
