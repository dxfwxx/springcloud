package com.springcloud.cn.authserver.conf;

import com.springcloud.cn.authserver.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.OAuth2AuthenticationProcessingFilter;
import org.springframework.security.oauth2.provider.token.AuthorizationServerTokenServices;
import org.springframework.security.oauth2.provider.token.DefaultTokenServices;
import org.springframework.security.oauth2.provider.token.store.redis.RedisTokenStore;

import javax.sql.DataSource;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Configuration
//声明一个认证服务器，当用此注解后，应用启动后将自动生成几个Endpoint：（注：其实实现一个认证服务器就是这么简单，加一个注解就搞定，当然真正用到生产环境还是要进行一些配置和复写工作的。）
//	/oauth/authorize：验证
//	/oauth/token：获取token
//	/oauth/confirm_access：用户授权
//	/oauth/error：认证失败
//	/oauth/check_token：资源服务器用来校验token
//	oauth/token_key：如果jwt模式则可以用此来从认证服务器获取公钥
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {
	
	@Autowired
	private UserService userService;
	@Autowired
    private AuthenticationManager authenticationManager;
	@Autowired
	private RedisConnectionFactory connectionFactory;
	
//	@Autowired
//	private DataSource dataSource;
	@Bean
	public RedisTokenStore tokenStore() {
		return new RedisTokenStore(connectionFactory);
	}
	
	@Primary
	@Bean
	public AuthorizationServerTokenServices tokenServices() {
		DefaultTokenServices defaultTokenServices = new DefaultTokenServices();
		defaultTokenServices.setSupportRefreshToken(true);
		defaultTokenServices.setReuseRefreshToken(false);
		defaultTokenServices.setAccessTokenValiditySeconds(500);
		defaultTokenServices.setRefreshTokenValiditySeconds(1000);
		defaultTokenServices.setTokenStore(tokenStore());
		return defaultTokenServices;
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints.authenticationManager(authenticationManager)
				.userDetailsService(userService)
				.tokenStore(tokenStore())
				.tokenServices(tokenServices());
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()").checkTokenAccess("isAuthenticated()")
				.allowFormAuthenticationForClients(); //允许通过form方式验证
	}
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
				.withClient("client")
				.scopes("xx") //此处的scopes是无用的，可以随意设置
				.secret("client")
				.authorizedGrantTypes("password")
				.and()
				.withClient("webapp")
				.scopes("xx")
				.authorizedGrantTypes("implicit");
	}
}
