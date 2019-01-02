package com.springcloud.common.commonserver;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication

public class CommonServerApplication {
	
//	private static Logger logger  = LoggerFactory.getLogger(CommonServerApplication.class);
	
	public static void main(String[] args) {
		SpringApplication.run(CommonServerApplication.class, args);
//		logger.info("CommonServerApplication start success.............");
	}
	
}

