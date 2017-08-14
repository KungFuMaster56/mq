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

@RestController
@RequestMapping("message")
public class MessageController {
	
	
	@Resource
	private QuartzMessageMapper mapper;
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
	
}
