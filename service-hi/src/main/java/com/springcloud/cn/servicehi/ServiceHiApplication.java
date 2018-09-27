package com.springcloud.cn.servicehi;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@SpringBootApplication
@EnableEurekaClient
@Controller
public class ServiceHiApplication {
	
	private static Logger logger = LoggerFactory.getLogger(ServiceHiApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceHiApplication.class, args);
		logger.info("ServiceHiApplication start success.............");
	}
}
