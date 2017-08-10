package com.htdf.ma.mq.producer;

import javax.jms.Destination;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;
/**
 * 
 * @ClassName: ProducerA 
 * @Description: 消息生产者
 * @author: 
 * @date: 2017年8月9日 下午3:43:36
 */
@Component
public class ProducerA {
	
	private  JmsTemplate jmsTemplete;
	
	@Autowired
	public ProducerA(JmsTemplate jmsTemplete){
		this.jmsTemplete = jmsTemplete;
	}
	
	public void sendMessage(Destination destination, String message){
		jmsTemplete.convertAndSend(destination, message);
	}
}
