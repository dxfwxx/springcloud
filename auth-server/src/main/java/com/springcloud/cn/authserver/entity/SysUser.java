package com.springcloud.cn.authserver.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class SysUser implements Serializable {
	
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		SysUser user = (SysUser) o;
		return Objects.equals(id, user.id) &&
				Objects.equals(roleId, user.roleId) &&
				Objects.equals(username, user.username) &&
				Objects.equals(password, user.password) &&
				Objects.equals(realName, user.realName) &&
				Objects.equals(roleList, user.roleList) &&
				Objects.equals(grantedAuthorityList, user.grantedAuthorityList);
	}
	
	@Override
	public int hashCode() {
		
		return Objects.hash(id, roleId, username, password, realName, roleList, grantedAuthorityList);
	}
}
