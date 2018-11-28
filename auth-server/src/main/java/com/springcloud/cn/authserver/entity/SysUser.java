package com.springcloud.cn.authserver.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class SysUser {
	
	private String id;
	
	private String roleId;
	
	private String username;
	
	private String password;
	
	private String realName;
	
	private List<SysRole> roleList;
	
	private List<GrantedAuthority> grantedAuthorityList;
	
	public List<GrantedAuthority> getGrantedAuthority() {
		List<GrantedAuthority> authorityList = new ArrayList<>();
		for(SysRole role : roleList) {
			for(SysAuthrotity authrotity : role.getAuthrotityList()) {
				authorityList.add(new SimpleGrantedAuthority(authrotity.getValue()));
			}
		}
		return authorityList;
	}
}
