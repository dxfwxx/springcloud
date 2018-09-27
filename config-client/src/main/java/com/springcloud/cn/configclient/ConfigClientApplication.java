package com.springcloud.cn.configclient;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ConfigClientApplication {
	
	private static Logger logger = LoggerFactory.getLogger(ConfigClientApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ConfigClientApplication.class, args);
		logger.info("EurekaServerApplication start success.............");
	}
}
