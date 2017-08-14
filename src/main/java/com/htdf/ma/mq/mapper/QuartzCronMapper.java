package com.htdf.ma.mq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.htdf.ma.mq.pojo.QuartzCron;

public interface QuartzCronMapper {
	

	void deleteBatch(@Param("qts")List<QuartzCron> qts);
	
	List<QuartzCron> getAll();
	
	void insertBatch(@Param("qts")List<QuartzCron> qts);
	
	void updateBatch(@Param("qts")List<QuartzCron> qts);
}
