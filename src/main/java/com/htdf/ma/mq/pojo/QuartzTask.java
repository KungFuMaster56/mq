package com.htdf.ma.mq.pojo;

public class QuartzTask {
	
	private Long id;
	
	private String task_key;
	
	private String group_key;
	
	private String trigger_key;
	
	private String message;
	
	private String cron;
	
	private String onoff;
	
	private boolean immediately;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTask_key() {
		return task_key;
	}

	public void setTask_key(String task_key) {
		this.task_key = task_key;
	}

	public String getGroup_key() {
		return group_key;
	}

	public void setGroup_key(String group_key) {
		this.group_key = group_key;
	}

	public String getTrigger_key() {
		return trigger_key;
	}

	public void setTrigger_key(String trigger_key) {
		this.trigger_key = trigger_key;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCron() {
		return cron;
	}

	public void setCron(String cron) {
		this.cron = cron;
	}

	public String getOnoff() {
		return onoff;
	}

	public void setOnoff(String onoff) {
		this.onoff = onoff;
	}

	public boolean isImmediately() {
		return immediately;
	}

	public void setImmediately(boolean immediately) {
		this.immediately = immediately;
	}
	
}
