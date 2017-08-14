package com.htdf.ma.mq.pojo;

public class QuartzCron {
	
	private Long id;
	
	private String cron;
	
	private String cron_name;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getCron_name() {
		return cron_name;
	}

	public void setCron_name(String cron_name) {
		this.cron_name = cron_name;
	}
	
	
}
