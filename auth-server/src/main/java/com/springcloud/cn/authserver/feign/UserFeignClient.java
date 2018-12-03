package com.springcloud.cn.authserver.feign;

import com.springcloud.cn.authserver.entity.SysUser;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Service
@FeignClient(value = "service-user")
public interface UserFeignClient {
	
	@RequestMapping(value = "/loadUserByUsername", method = RequestMethod.POST)
	SysUser loadUserByUsername(String username);
}
