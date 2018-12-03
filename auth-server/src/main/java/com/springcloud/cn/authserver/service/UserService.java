package com.springcloud.cn.authserver.service;

import com.springcloud.cn.authserver.entity.SysUser;
import com.springcloud.cn.authserver.feign.UserFeignClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Service
public class UserService implements UserDetailsService {
	private static Logger logger = LoggerFactory.getLogger(UserService.class);

	@Autowired
	private UserFeignClient userFeignClient;
	
	@Override
	public UserDetails loadUserByUsername(String username) {
		SysUser user = new SysUser();
		try {
			user = userFeignClient.loadUserByUsername(username);
		} catch (Exception e) {
			throw new UsernameNotFoundException("用户名不存在");
		}
//		SysUser user = userFeignClient.loadUserByUsername(username);
		logger.info("loadUserByUsername result is {}", user);
		UserDetails userDetails = new User(user.getUsername(), user.getPassword().toLowerCase(), true, true, true, true, user.getGrantedAuthority());
		
		return userDetails;
	}

}
