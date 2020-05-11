package com.test;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class HashMapTest {
	public static void main(String[] args) {
		People people = new People();
		people.setId(UUID.randomUUID().toString());
		people.setName("name");
		Map<People, People> map = new HashMap<>();
		map.put(people, people);
		People people1 = new People();
		people1.setName("name");
		System.out.println(map.get(people1));
	}
}
