package com.springcloud.cn.serviceuser.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class SysUser implements Serializable {
	public SysUser() {
	
	}
	
	public SysUser(String id, String roleId, String username, String password, String realName, List<SysRole> roleList) {
		this.id = id;
		this.roleId = roleId;
		this.username = username;
		this.password = password;
		this.realName = realName;
		this.roleList = roleList;
	}
	
	private String id;
	
	private String roleId;
	
	private String username;
	
	private String password;
	
	private String realName;
	
	private List<SysRole> roleList;
}
