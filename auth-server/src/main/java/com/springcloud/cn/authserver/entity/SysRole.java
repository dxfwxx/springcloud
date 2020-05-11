package com.springcloud.cn.authserver.entity;

import lombok.Data;

import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class SysRole {
	
	private String id;
	
	private String name;
	
	private String userId;
	
	private String value;
	
	List<SysAuthrotity> authrotityList;
}
