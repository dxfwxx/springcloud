package com.springcloud.common.commonserver;


import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@EnableDiscoveryClient
@Slf4j
public class CommonServerApplication {
	
//	private static Logger logger  = LoggerFactory.getLogger(CommonServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CommonServerApplication.class, args);
		log.info("CommonServerApplication start success.............");
	}
	
}

