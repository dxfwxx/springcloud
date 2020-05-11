package com.springcloud.cn.serviceuser.service;

import com.springcloud.cn.serviceuser.entity.SysUser;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public interface UserService {
	
	SysUser loadUserByUsername(String username);
	
}
