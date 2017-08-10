package com.htdf.ma.mq;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.htdf.ma.mq.producer.ProducerA;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MqApplicationTests {
	
	@Resource
	private ProducerA p;

	@Test
	public void contextLoads() {
		Destination destination = new ActiveMQTopic("msg.topic");
		p.sendMessage(destination, "A"); 
	}

}
