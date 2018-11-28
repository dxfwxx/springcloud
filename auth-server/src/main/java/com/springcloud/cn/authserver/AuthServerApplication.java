package com.springcloud.cn.authserver;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
@EnableDiscoveryClient
@MapperScan({"com.springcloud.cn.authserver.dao"})
public class AuthServerApplication {
	private static Logger logger = LoggerFactory.getLogger(AuthServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(AuthServerApplication.class, args);
		logger.info("AuthServerApplication start success.............");
	}
}
