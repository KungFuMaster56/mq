package com.htdf.ma.mq.consumer;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerA {
	
	@JmsListener(destination="msg.p2p.queue")
	public void processMessage(String content){
		
		System.out.println("Receiving a message :" + content);

	}
}
