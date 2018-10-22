package com.springcloud.cn.entity;

import lombok.Data;

import java.io.*;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class Head implements Cloneable, Serializable {
	
//	private Eye eye;
	private String type;
	
	public Head() {}
	
	public Head(String type) {
		this.type = type;
	}
	
	@Override
	public Head clone() throws CloneNotSupportedException{
		return (Head) super.clone();
	}
	
	
	
}
