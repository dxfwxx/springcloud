package com.springcloud.cn.servicefeign;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import javax.xml.ws.Service;

@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients
public class ServiceFeignApplication {
	
	private static Logger logger = LoggerFactory.getLogger(ServiceFeignApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ServiceFeignApplication.class, args);
		logger.info("ServiceFeignApplication start success.............");
	}
}
