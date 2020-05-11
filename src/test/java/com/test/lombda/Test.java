package com.test.lombda;

import com.test.People;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class Test {
	public static void main(String[] args) {
		List<People> list = new ArrayList<>();
		People people = new People();
		people.setId("1");
		people.setName("1");
		People people1 = new People();
		people1.setId("1");
		people1.setName("2");
		People people2 = new People();
		people2.setId("2");
		people2.setName("2");
		
		list.add(people);
		list.add(people1);
		list.add(people2);
		Map<String, String> map = list.stream().collect(Collectors.toMap(People::getId, People::getName, (key1, key2) -> key2));
		System.out.println(map);
	}
}
