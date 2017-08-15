package com.htdf.ma.mq;

import org.mybatis.spring.annotation.MapperScan;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;

@SpringBootApplication
@MapperScan("com.htdf.ma.mq.mapper")
public class MqApplication {

	@Bean
	public StdSchedulerFactory schedulerBean (){
		StdSchedulerFactory sfb = new StdSchedulerFactory();
		return sfb;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(MqApplication.class, args);
	}
}
