package com.springcloud.cn.authserver.conf;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Configuration
public class PermitAllConfig {
	
	@Bean
	@ConfigurationProperties(prefix = "auth")
	public PermitAllUrlProperties getPermitAllUrlProperties() {
		return new PermitAllUrlProperties();
	}
}
