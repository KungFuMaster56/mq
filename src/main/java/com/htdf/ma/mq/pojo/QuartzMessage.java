package com.htdf.ma.mq.pojo;

public class QuartzMessage {
	
	private Long id;
	
	private String message_code;
	
	private String message_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMessage_code() {
		return message_code;
	}

	public void setMessage_code(String message_code) {
		this.message_code = message_code;
	}

	public String getMessage_name() {
		return message_name;
	}

	public void setMessage_name(String message_name) {
		this.message_name = message_name;
	}
	
	
}
