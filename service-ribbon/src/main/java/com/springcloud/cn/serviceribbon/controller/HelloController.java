package com.springcloud.cn.serviceribbon.controller;

import com.springcloud.cn.serviceribbon.service.HelloService;
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
	private HelloService helloService;
	
	@GetMapping(value = "/hi")
	@ResponseBody
	public String hi(@RequestParam String name, String token) {
		return helloService.hi(name);
	}
}
