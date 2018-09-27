package com.springcloud.cn.serviceribbon.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Configuration
public class RestTemplateConfig {
	@Autowired
	private RestTemplateBuilder builder;
	
	@Bean
	@LoadBalanced
	public RestTemplate restTemplate() {
		return builder.build();
	}
	
}
