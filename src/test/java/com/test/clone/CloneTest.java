package com.test.clone;

import com.springcloud.cn.entity.Animal;
import com.springcloud.cn.entity.Head;
import org.springframework.beans.BeanUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class CloneTest {
	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		Head head = new Head("丹凤三角眼");
		Animal animal = new Animal("animal", 10, head);

		System.out.println("----BeanUtils.copyProperties---");
		Animal animal2 = new Animal();
		BeanUtils.copyProperties(animal, animal2);
		System.out.println(animal == animal2);
		System.out.println(animal.getName() == animal2.getName());
		System.out.println(animal.getHead().getType() == animal2.getHead().getType());
		animal2.getHead().setType("zhutong");
		animal2.setName("cat");
		System.out.println("animal2 head.type :" + animal2.getHead().getType() + "  animal head.type :"+ animal.getHead().getType());
		System.out.println("animal2 name:" + animal2.getName() + "  animal :" + animal.getName());

		System.out.println("----clone----");
		Animal animal3 = animal.clone();
		System.out.println(animal == animal3);
		System.out.println(animal.getName() == animal3.getName());
		System.out.println(animal.getAge() == animal3.getAge());
		System.out.println(animal.getHead() == animal3.getHead());
		System.out.println(animal.getHead().getType() == animal3.getHead().getType());
		animal3.getHead().setType("zhutong1");
		animal3.setName("dog");
//		animal3.setAge(9);
		System.out.println("animal3 head.type :" + animal3.getHead().getType() + "  animal head.type :"+ animal.getHead().getType());
		System.out.println("animal3 name:" + animal3.getName() + "  animal :" + animal.getName());
		System.out.println("animal3 age:" + animal3.getAge() + "  animal :" + animal.getAge());
		System.out.println(animal.getName() == animal3.getName());
		System.out.println(animal.getAge() == animal3.getAge());
		System.out.println(animal.getHead() == animal3.getHead());
		System.out.println(animal.getHead().getType() == animal3.getHead().getType());


		System.out.println("----deepClone----");
		Animal animal4 = animal.deepClone();
		System.out.println(animal == animal4);
		System.out.println(animal.getName() == animal4.getName());
		animal4.getHead().setType("zhutong2");
		System.out.println("animal4 head.type :" + animal4.getHead().getType() + "  animal head.type :"+ animal.getHead().getType());


		System.out.println("----string----");
//		String str = new String("zhutong");
//		String str2 = new String("zhutong");
//		System.out.println(str == str2);
		String str3 = "zhutong";
		String str4 = "zhutong";
		System.out.println(str3 == str4);

		System.out.println("---list----");
		List<Integer> list = Arrays.asList(1, 2, 3);
		List<Integer> newList = new ArrayList<>(list);
		List<Integer> newList2 = list;
		newList.set(0, 0);
		newList2.set(0, -1);
		System.out.println(newList == list);
		System.out.println(newList2 == list);
		System.out.println(newList);
		System.out.println(list);

	}
}
