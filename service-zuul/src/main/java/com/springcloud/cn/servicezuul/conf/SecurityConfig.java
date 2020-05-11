package com.springcloud.cn.servicezuul.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.security.oauth2.client.OAuth2RestOperations;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.resource.OAuth2ProtectedResourceDetails;
import org.springframework.security.oauth2.client.test.OAuth2ContextConfiguration;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Configuration
@EnableOAuth2Sso
@EnableZuulProxy
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
	}
	
}