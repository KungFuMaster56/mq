package com.htdf.ma.mq.service;

import javax.jms.Destination;

public interface NoticeService {
	
	/**
	 * 
	 * @Title: sendMessage 
	 * @Description: 发送消息
	 * @param destination
	 * @param message
	 * @return: void
	 */
	 void sendMessage(Destination destination, String message);
}
