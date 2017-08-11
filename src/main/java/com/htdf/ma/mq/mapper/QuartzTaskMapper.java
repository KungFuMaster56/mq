package com.htdf.ma.mq.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.htdf.ma.mq.pojo.QuartzTask;

public interface QuartzTaskMapper {
	
	@Insert("INSERT INTO quartz_task (task_key,group_key,trigger_key,message,cron)VALUES(#{task_key},#{group_key},#{trigger_key},#{message},#{cron})")
	void insert(QuartzTask qt);
	
	@Delete("DELETE FROM quartz_task WHERE id =#{id}")
	void delete(Long id);
	
	@Update("UPDATE quartz_task SET cron =#{cron} WHERE id=#{id}")
	void update(QuartzTask qt);
	
	@Select("SELECT * FROM quartz_task")
	List<QuartzTask> getAll();
}
