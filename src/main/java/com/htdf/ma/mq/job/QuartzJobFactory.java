package com.htdf.ma.mq.job;

import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQTopic;
import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.htdf.ma.mq.service.NoticeService;
import com.htdf.ma.mq.util.SpringContext;

@DisallowConcurrentExecution
public class QuartzJobFactory implements Job{

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		String topic = context.getMergedJobDataMap().getString("message");
		String onoff = context.getMergedJobDataMap().getString("onoff");
		Destination destination = new ActiveMQTopic(topic);
		NoticeService noticeService = (NoticeService) SpringContext.getBean("noticeService");
		noticeService.sendMessage(destination, onoff);
	}
}
