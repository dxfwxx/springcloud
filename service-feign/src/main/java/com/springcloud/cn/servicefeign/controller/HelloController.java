package com.springcloud.cn.servicefeign.controller;

import com.springcloud.cn.servicefeign.service.ScheduleServiceHi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Controller
public class HelloController {
	
	@Autowired
	private ScheduleServiceHi scheduleServiceHi;
	
	@GetMapping(value = "hi")
	@ResponseBody
	public String hello(@RequestParam String name) {
		return scheduleServiceHi.sayHiFromClientOne(name);
	}
}
