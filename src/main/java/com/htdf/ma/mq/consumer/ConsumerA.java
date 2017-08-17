package com.htdf.ma.mq.consumer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class ConsumerA {
	
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@JmsListener(destination="ASM")
	public void processMessage(String content){
		
		logger.info("Receiving a message :{}",content);

	}
}
