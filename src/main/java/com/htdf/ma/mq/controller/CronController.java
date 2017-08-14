package com.htdf.ma.mq.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.htdf.ma.mq.mapper.QuartzCronMapper;
import com.htdf.ma.mq.pojo.QuartzCron;

@RestController
@RequestMapping("cron")
public class CronController {
	
	@Resource
	private QuartzCronMapper mapper;
	/**
	 * 
	 * @Title: quartzCron 
	 * @Description: 新增调度Cron
	 * @return: void
	 */
	@PostMapping
	public void PosCron(@RequestBody List<QuartzCron> qts){
		mapper.insertBatch(qts);
	}
	
	/**
	 * 
	 * @Title: DelQuartzCron 
	 * @Description: 删除调度Cron
	 * @param id
	 * @return: void
	 */
	@DeleteMapping
	public void DelCron(@RequestBody List<QuartzCron> qts){
		mapper.deleteBatch(qts);
	}
	
	/**
	 * 
	 * @Title: UpdQuartzCron 
	 * @Description: 修改调度Cron
	 * @param id
	 * @return: void
	 */
	@PutMapping
	public void UpdCron(@RequestBody List<QuartzCron> qts){
		mapper.updateBatch(qts);
	}
	
	/**
	 * 
	 * @Title: GetCron 
	 * @Description: 查询调度Cron
	 * @return
	 * @return: List<QuartzCron>
	 */
	@GetMapping
	public List<QuartzCron> GetCron(){
		return mapper.getAll();
	}
	
}
