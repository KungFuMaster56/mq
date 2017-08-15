package com.htdf.ma.mq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.htdf.ma.mq.pojo.QuartzTask;

public interface QuartzTaskMapper {

	void deleteBatch(@Param("qts")List<QuartzTask> qts);
	
	List<QuartzTask> getAll();
	
	void insertBatch(@Param("qts")List<QuartzTask> qts);
	
	void updateBatch(@Param("qts")List<QuartzTask> qts);
	
	void update(QuartzTask qt);
}
