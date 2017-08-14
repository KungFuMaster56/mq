package com.htdf.ma.mq.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
	
	@RequestMapping("/")
	public ModelAndView index(){
		ModelAndView mv = new ModelAndView("home");
		return mv;
	}
	
	@RequestMapping("message_index")
	public ModelAndView messageIndex(){
		ModelAndView mv = new ModelAndView("message");
		return mv;
	}
	
	@RequestMapping("cron_index")
	public ModelAndView cronIndex(){
		ModelAndView mv = new ModelAndView("cron");
		return mv;
	}
}
