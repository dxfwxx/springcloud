package com.springcloud.cn.authserver.repository;

import com.springcloud.cn.authserver.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Mapper
public interface UserDao {
	
	SysUser findUserByUserName(@Param("username") String username);
	
}
