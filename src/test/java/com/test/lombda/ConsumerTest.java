package com.test.lombda;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class ConsumerTest {
	public static void main(String[] args) {
//		System.out.println("consumerTest:  ");
//		consumerTest();
//		System.out.println("functionTest:  ");
//		functionTest();
		System.out.println("predicateTest:  ");
		predicateTest();
//		System.out.println("optionalTest:  ");
//		optionalTest();
//
//		System.out.println(TestEnum.TEST_ENUM_ONE.getFlag());
	}
	
	public static void consumerTest() {
		Consumer f = System.out::println;
		Consumer f2 = n -> System.out.println(n + "-f2");
		Consumer<Integer> f3 = n -> System.out.println(++n);
		
		f.accept("test");
		f3.accept(3);
		//执行完F后再执行F2的Accept方法
		f.andThen(f2).accept("test");
		//连续执行F的Accept方法
		f.andThen(f).andThen(f).andThen(f).accept("test1");
	}
	
	
	public static void functionTest() {
		Function<Integer, Integer> f = s -> ++s;
		Function<Integer, Integer> g = s -> s * 2;
		
		/**
		 * 下面表示在执行F时，先执行G，并且执行F时使用G的输出当作输入。
		 * 相当于以下代码：
		 * Integer a = g.apply(2);
		 * System.out.println(f.apply(a));
		 */
		System.out.println(f.compose(g).apply(2));
		
		/**
		 * 表示执行F的Apply后使用其返回的值当作输入再执行G的Apply；
		 * 相当于以下代码
		 * Integer a = f.apply(2);
		 * System.out.println(g.apply(a));
		 */
		System.out.println(f.andThen(g).apply(2));
		
		/**
		 * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
		 */
		System.out.println(Function.identity().apply("a"));
	}
	
	public static void predicateTest() {
		Predicate<String> p = o -> ("test").equals(o);
		Predicate<String> g = o -> o.startsWith("e");
		
		/**
		 * negate: 用于对原来的Predicate做取反处理；
		 * 如当调用p.test("test")为True时，调用p.negate().test("test")就会是False；
		 */
		System.out.println(p.negate().test("test"));
		/**
		 * and: 针对同一输入值，多个Predicate均返回True时返回True，否则返回False；
		 */
		System.out.println(p.and(g).test("test"));
		/**
		 * or: 针对同一输入值，多个Predicate只要有一个返回True则返回True，否则返回False
		 */
		System.out.println(p.or(g).test("test"));
	}
	
	public static void optionalTest() {
		Optional o = Optional.of("test");
		
//		Optional o2 = Optional.of(null);
		
		Optional o3 = Optional.ofNullable(null);
		
		o3.ifPresent(System.out::println);
		
		System.out.println(o3.isPresent());
		
		System.out.println(o3.orElse("test null"));
		
		try {
			System.out.println(o3.orElseThrow(() -> new Exception("test null exception")));
		} catch (Throwable throwable) {
			System.out.println(throwable.getMessage());
		}
		
	}
}
