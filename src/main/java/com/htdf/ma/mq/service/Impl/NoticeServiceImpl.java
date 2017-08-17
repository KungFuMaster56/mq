package com.htdf.ma.mq.service.Impl;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;

import com.htdf.ma.mq.service.NoticeService;
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService{
	
	private JmsTemplate jmsTemplate;
	
	@Autowired
	public NoticeServiceImpl(JmsTemplate jmsTemplate){
		this.jmsTemplate=jmsTemplate;
	}

	@Override
	public void sendMessage(Destination destination, String message) {
		jmsTemplate.setSessionTransacted(true);
		jmsTemplate.convertAndSend(destination, message);
	}
	
	
}
