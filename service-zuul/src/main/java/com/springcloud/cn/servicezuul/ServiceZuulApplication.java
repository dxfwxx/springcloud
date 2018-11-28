package com.springcloud.cn.servicezuul;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
@EnableOAuth2Sso
public class ServiceZuulApplication {

	private static Logger logger = LoggerFactory.getLogger(ServiceZuulApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(ServiceZuulApplication.class, args);
		logger.info("ServiceZuulApplication start success.............");
	}
}
