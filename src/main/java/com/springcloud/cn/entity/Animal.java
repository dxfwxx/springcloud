package com.springcloud.cn.entity;


import lombok.Data;

import java.io.*;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Data
public class Animal implements Cloneable, Serializable{
	
	private String name;
	
	private Integer age;
	
	private Head head;
	
	public Animal() {}
	
	public Animal(String name, Integer age, Head head) {
		this.name = name;
		this.head = head;
		this.age = age;
	}
	
	@Override
	public Animal clone() throws CloneNotSupportedException {
		Animal animal = (Animal) super.clone();
		animal.setHead(this.head.clone());
		return animal;
	}
	public Animal deepClone() throws IOException, ClassNotFoundException{
		ByteArrayOutputStream bos = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(bos);
		oos.writeObject(this);
		oos.flush();
		byte[] objBytes = bos.toByteArray();
		oos.close();
		
		ByteArrayInputStream bis = new ByteArrayInputStream(objBytes);
		ObjectInputStream ios = new ObjectInputStream(bis);
		Object obj= ios.readObject();
		ios.close();
		return (Animal) obj;
	}
}
