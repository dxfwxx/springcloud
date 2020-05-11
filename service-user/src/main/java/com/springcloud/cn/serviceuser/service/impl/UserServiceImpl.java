package com.springcloud.cn.serviceuser.service.impl;

import com.springcloud.cn.serviceuser.entity.SysUser;
import com.springcloud.cn.serviceuser.repository.AuthDao;
import com.springcloud.cn.serviceuser.repository.UserDao;
import com.springcloud.cn.serviceuser.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Service
public class UserServiceImpl implements UserService {
	
	private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
	
	@Autowired
	private UserDao userDao;
	@Autowired
	private AuthDao authDao;
	
	@Override
	public SysUser loadUserByUsername(String username) {
		logger.debug("loadUserByUsername param is {}", username);
		
		SysUser user = userDao.findUserByUserName(username);
		user.setRoleList(authDao.findAuthByRoleList(user.getRoleList()));
		logger.info("loadUserByUsername result is {}", user);
//		UserDetails userDetails = new User(user.getUsername(), user.getPassword().toLowerCase(), true, true, true, true, user.getGrantedAuthority());
		return user;
	}
	private Collection<GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return authList;
	}
}
