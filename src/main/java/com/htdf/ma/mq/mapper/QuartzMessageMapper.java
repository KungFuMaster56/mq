package com.htdf.ma.mq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.htdf.ma.mq.pojo.QuartzMessage;

public interface QuartzMessageMapper {
	

	void deleteBatch(@Param("qts")List<QuartzMessage> qts);
	
	List<QuartzMessage> getAll();
	
	void insertBatch(@Param("qts")List<QuartzMessage> qts);
	
	void updateBatch(@Param("qts")List<QuartzMessage> qts);
}
