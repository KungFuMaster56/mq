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

import com.htdf.ma.mq.mapper.QuartzMessageMapper;
import com.htdf.ma.mq.pojo.QuartzMessage;
import com.htdf.ma.mq.pojo.QuartzTask;
import com.htdf.ma.mq.service.SchedulerService;

@RestController
@RequestMapping("message")
public class MessageController {
	
	
	@Resource
	private QuartzMessageMapper mapper;
	
	@Resource
	private SchedulerService schedulerService;
	/**
	 * 
	 * @Title: quartzMessage 
	 * @Description: 新增调度消息
	 * @return: void
	 */
	@PostMapping
	public void PosMessage(@RequestBody List<QuartzMessage> qts){
		mapper.insertBatch(qts);
	}
	
	/**
	 * 
	 * @Title: DelQuartzMessage 
	 * @Description: 删除调度消息
	 * @param id
	 * @return: void
	 */
	@DeleteMapping
	public void DelMessage(@RequestBody List<QuartzMessage> qts){
		mapper.deleteBatch(qts);
	}
	
	/**
	 * 
	 * @Title: UpdQuartzMessage 
	 * @Description: 修改调度消息
	 * @param id
	 * @return: void
	 */
	@PutMapping
	public void UpdMessage(@RequestBody List<QuartzMessage> qts){
		mapper.updateBatch(qts);
	}
	
	/**
	 * 
	 * @Title: GetMessage 
	 * @Description: 查询调度消息
	 * @return
	 * @return: List<QuartzMessage>
	 */
	@GetMapping
	public List<QuartzMessage> GetMessage(){
		return mapper.getAll();
	}
	
	/**
	 * 
	 * @Title: addSchedulerMessage 
	 * @Description: 发送消息启动定时任务
	 * @param qt
	 * @return: void
	 */
	@PostMapping("/scheduler")
	public void addSchedulerMessage(@RequestBody QuartzTask qt){
		schedulerService.addScheduler(qt);
	}
	
	/**
	 * 
	 * @Title: delSchedulerMessage 
	 * @Description: 发送消息关闭定时任务
	 * @param qt
	 * @return: void
	 */
	@DeleteMapping("/scheduler")
	public void delSchedulerMessage(@RequestBody QuartzTask qt){
		schedulerService.delScheduler(qt);
	}
	
}
