package com.springcloud.cn.servicehi.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class People {
	
	private String name;
	
	private List<String> nameList = new ArrayList<>();
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public List<String> getNameList() {
		return nameList;
	}
	
	public void setNameList(List<String> nameList) {
		this.nameList = nameList;
	}
}
