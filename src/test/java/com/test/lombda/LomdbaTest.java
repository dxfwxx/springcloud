package com.test.lombda;

import com.test.People;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class LomdbaTest {
	/***
	 *  例1、用lambda表达式实现Runnable  简化接口式的匿名内部类实现（接口只有一个方法）
	 */
	@Test
	public void test() {
		
		// Java 8之前：
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before Java8, too much code for too little to do");
			}
		}).start();
		//Java 8之后：
		new Thread( () -> {
			System.out.println("after Java8, Lambda expression!!");
			
		} ).start();
		
	}
	
	/***
	 * 例2、使用lambda表达式对列表进行迭代
	 */
	@Test
	public void test2() {
		// Java 8之前：
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		for (String feature : features) {
			System.out.println(feature);
		}
		
		// Java 8之后：
		features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		features.forEach(n -> System.out.println(n));
		System.out.println("------");
		
		// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
		// 看起来像C++的作用域解析运算符
		features.forEach(System.out::println);
		System.out.println("------");
	}
	/***
	 * 例3、map 映射
	 */
	@Test
	public void test3() {
		// 转换大写
		List<String> features = Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
		System.out.println(features.stream().map(String::toUpperCase));
		System.out.println(features.stream().map(String::toUpperCase).distinct().collect(Collectors.toList()));
	}
	/***sink
	 * 例4、Java 8中使用lambda表达式的Map和Reduce示例
	 */
	@Test
	public void test4() {
		// 不使用lambda表达式为每个订单加上12%的税
		List<Integer> costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12 * cost;
			System.out.println(price);
		}
		
		// 使用lambda表达式
		costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		costBeforeTax.stream().map((cost) -> cost + 0.12 * cost).forEach(System.out::println);
		
		
		
		// 不使用lambda表达式为每个订单加上12%的税
		costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double total = 0;
		for (Integer cost : costBeforeTax) {
			double price = cost + 0.12*cost;
			total = total + price;
		}
		System.out.println("Total : " + total);
		
		// 使用lambda表达式
		costBeforeTax = Arrays.asList(100, 200, 300, 400, 500);
		double bill = costBeforeTax.stream().map((cost) -> cost + 0.12*cost).reduce((sum, cost) -> sum + cost).get();
		System.out.println("Total : " + bill);
		
		BigDecimal a = new BigDecimal(1);
		People people = new People();
		List<People> list = new ArrayList<>();
		list.add(people);
//		list.stream().collect(Collectors.groupingBy(x -> x, Collectors.reducing(v -> v.getValue(), BigDecimal::add)));
	}
	
	
	/***
	 * 例5、filter 过滤  使用lambda表达式和函数式接口Predicate
	 */
	@Test
	public void test5() {
		List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		
		System.out.println("Languages which starts with J :");
		filter(languages, (str)->str.toString().startsWith("J"));
		
		System.out.println("Languages which ends with a :");
		filter(languages, (str)->str.toString().endsWith("a"));
		
		System.out.println("Print all languages :");
		filter(languages, (str)->true);
		
		System.out.println("Print no language : ");
		filter(languages, (str)->false);
		
		System.out.println("Print language whose length greater than 4:");
		filter(languages, (str)->str.toString().length() > 4);
		
		
		
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		filter2(languages, startsWithJ, fourLetterLong);
	}
	
	public static void filter(List<String> names, Predicate condition) {
		names.stream().filter(condition).forEach(System.out::println);
	}
	
	public static void filter2(List<String> names, Predicate startsWithJ, Predicate fourLetterLong) {
		
		names.stream().filter(startsWithJ.and(fourLetterLong))
				.forEach((n) -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));
		
		names.stream().filter(startsWithJ.or(fourLetterLong))
				.forEach((n) -> System.out.println("nName, which starts with 'J' or four letter long is : " + n));
	}
	
	/***
	 * 例6、distinct  sorted  limit
	 */
	@Test
	public void test6() {
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		System.out.println("distinct list is : ");
		numbers.stream().map(i -> i * i).distinct().forEach(System.out::println);
		System.out.println("sorted list is : ");
		numbers.stream().sorted().forEach(System.out::println);
		System.out.println("limit 5 list is : ");
		numbers.stream().limit(5).forEach(System.out::println);
	}
	/***
	 * 例7、对列表的每个元素应用函数
	 *  collect 收集
	 */
	@Test
	public void test7() {
		// 将字符串换成大写并用逗号链接起来
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", ", "[", "]"));
		System.out.println(G7Countries);
		// 最小值，返回optional
		Optional optional = G7.stream().collect(Collectors.minBy(String::compareTo));
		System.out.println(optional.get());
		
		// 条件分组
		System.out.println(G7.stream().collect(Collectors.groupingBy(x -> x)));
		System.out.println(G7.stream().collect(Collectors.groupingBy(x -> x, Collectors.counting())));
		
		// 条件划分
		System.out.println(G7.stream().collect(Collectors.partitioningBy(x -> x.length() > 4)));
		System.out.println(G7.stream().collect(Collectors.partitioningBy(x -> x.length() > 4, Collectors.counting())));
		
		//先进行join，然后在最后加上 ",China"
		String str = G7.stream().collect(Collectors.collectingAndThen(Collectors.joining(","), x -> x + ",China"));
		System.out.println(str);
	}
	
	
	/***
	 * 例10、计算集合元素的最大值、最小值、总和以及平均值
	 */
	@Test
	public void test9() {
		//获取数字的个数、最小值、最大值、总和以及平均值
		List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
		IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
		System.out.println("Highest prime number in List : " + stats.getMax());
		System.out.println("Lowest prime number in List : " + stats.getMin());
		System.out.println("Sum of all prime numbers : " + stats.getSum());
		System.out.println("Average of all prime numbers : " + stats.getAverage());
	}
}
