package com.springcloud.cn.authserver.repository;

import com.springcloud.cn.authserver.entity.SysRole;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Mapper
public interface AuthDao {
	
	List<SysRole> findAuthByRoleList(List<SysRole> list);
}
