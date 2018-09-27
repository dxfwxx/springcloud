package com.springcloud.cn.servicehi.controller;

import com.springcloud.cn.servicehi.ServiceHiApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
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
	
	private static Logger logger = LoggerFactory.getLogger(ServiceHiApplication.class);
	
	@Value("${server.port}")
	private String port;
	
	@GetMapping(value = "/hi")
	@ResponseBody
	public String hello(@RequestParam String name) {
		return "hello: " + name + ", your port is " + port;
	}
}
