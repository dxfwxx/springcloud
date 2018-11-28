package com.springcloud.cn.authserver.service;

import com.springcloud.cn.authserver.entity.SysUser;
import com.springcloud.cn.authserver.repository.AuthDao;
import com.springcloud.cn.authserver.repository.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Service
public class UserService implements UserDetailsService {
	@Autowired
	private UserDao userDao;
	
	@Autowired
	private AuthDao authDao;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		SysUser user = userDao.findUserByUserName(username);
		user.setRoleList(authDao.findAuthByRoleList(user.getRoleList()));
		UserDetails userDetails = new User(user.getUsername(), user.getPassword().toLowerCase(), true, true, true, true, user.getGrantedAuthority());
		return userDetails;
	}
	private Collection<GrantedAuthority> getAuthorities(){
		List<GrantedAuthority> authList = new ArrayList<>();
		authList.add(new SimpleGrantedAuthority("ROLE_USER"));
		authList.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		return authList;
	}
}
