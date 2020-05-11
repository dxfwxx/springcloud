package com.springcloud.cn.serviceuser.entity;

import lombok.Data;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class Person {
	private String name;
	
	private String city;
	
	private String country;
	
	private Integer age;
	
	private String like;
	
	public Person(String name, String city, String country, Integer age, String like) {
		this.name = name;
		this.city = city;
		this.country = country;
		this.age = age;
		this.like = like;
	}
}
