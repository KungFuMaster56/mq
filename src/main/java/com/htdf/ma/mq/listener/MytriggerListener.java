package com.htdf.ma.mq.listener;

import org.quartz.JobExecutionContext;
import org.quartz.Trigger;
import org.quartz.Trigger.CompletedExecutionInstruction;
import org.quartz.TriggerListener;
import org.springframework.stereotype.Component;

@Component
public class MytriggerListener implements TriggerListener{

	@Override
	public String getName() {
		return "triggerListener";
	}

	@Override
	public void triggerFired(Trigger trigger, JobExecutionContext context) {
		System.out.println(trigger.getKey()+" trigger start at "+trigger.getStartTime());
	}

	@Override
	public boolean vetoJobExecution(Trigger trigger, JobExecutionContext context) {
		System.out.println(trigger.getKey()+" trigger veto ");
		return false;
	}

	@Override
	public void triggerMisfired(Trigger trigger) {
		System.out.println(trigger.getKey()+" trigger misfired ");
		
	}

	@Override
	public void triggerComplete(Trigger trigger, JobExecutionContext context,
			CompletedExecutionInstruction triggerInstructionCode) {
		System.out.println(trigger.getKey()+" trigger complete ");
		
	}
}
