package com.test.lombda;

import lombok.Getter;
import lombok.ToString;

import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
@Getter
@ToString
public enum TestEnum {
	
	TEST_ENUM_ONE(1, false, "test", o -> ("test").equals(o)),
	TEST_ENUM_TWO(2, false, "test", o -> ("test").equals(o)),
	;
	
	
	
	private Integer code;
	
	private Boolean flag;
	
	private String name;
	
	private Predicate predicate;
	
	TestEnum(Integer code, Boolean flag, String name, Predicate predicate) {
		this.code = code;
		this.predicate = predicate;
		this.name = name;
		this.flag = predicate.test(name);
	}
}
