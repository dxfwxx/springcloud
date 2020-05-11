package com.springcloud.cn.serviceuser.repository;

import com.springcloud.cn.serviceuser.entity.SysUser;
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
