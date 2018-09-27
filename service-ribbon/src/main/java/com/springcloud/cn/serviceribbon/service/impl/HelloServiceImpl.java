package com.springcloud.cn.serviceribbon.service.impl;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.springcloud.cn.serviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Service
public class HelloServiceImpl implements HelloService {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@HystrixCommand(fallbackMethod = "hiError")
	@Override
	public String hi(String name) {
		return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
	}
	
	public String hiError(String name) {
		return "hi, " + name + "  sorry, rest error";
	}
}
