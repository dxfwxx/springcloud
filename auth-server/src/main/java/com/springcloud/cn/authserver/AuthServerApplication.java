package com.springcloud.cn.authserver;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class AuthServerApplication {
	private static Logger logger = LoggerFactory.getLogger(AuthServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
		logger.info("AuthServerApplication start success.............");
	}
}
