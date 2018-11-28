package com.springcloud.cn.authserver.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.util.matcher.RequestMatcher;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	private static class OAuth2RequestMather implements RequestMatcher{
		
		@Override
		public boolean matches(HttpServletRequest httpServletRequest) {
			if(httpServletRequest.getParameter(OAuth2AccessToken.ACCESS_TOKEN) != null) {
				return true;
			}
			String auth = httpServletRequest.getHeader("Authorization");
			if(auth != null) {
				if(auth.startsWith(OAuth2AccessToken.BEARER_TYPE)) {
					return true;
				}
			}
			return false;
		}
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatcher(new OAuth2RequestMather()).authorizeRequests()
				.anyRequest()
				.authenticated();
	}
}
