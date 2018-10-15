package com.test.inner;

import org.junit.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class LomdbaTest {
	/***
	 *  例1、用lambda表达式实现Runnable
	 */
	@Test
	public void test1() {
		
		// Java 8之前：
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Before Java8, too much code for too little to do");
			}
		}).start();
		//Java 8之后：
		new Thread( () -> System.out.println("In Java8, Lambda expression rocks !!") ).start();
	}
	
	
	/***
	 * 例3、使用lambda表达式对列表进行迭代
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
		
		// 使用Java 8的方法引用更方便，方法引用由::双冒号操作符标示，
		// 看起来像C++的作用域解析运算符
		features.forEach(System.out::println);
	}
	
	
	/***
	 * 例4、使用lambda表达式和函数式接口Predicate
	 */
	@Test
	public void test3() {
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
	}
	
	public static void filter(List<String> names, Predicate condition) {
		names.stream().filter((name) -> (condition.test(name))).forEach((name) -> {
			System.out.println(name + " ");
		});
	}
	
	
	/***
	 * 例5、如何在lambda表达式中加入Predicate
	 */
	@Test
	public void test4() {
		// 甚至可以用and()、or()和xor()逻辑函数来合并Predicate，
		// 例如要找到所有以J开始，长度为四个字母的名字，你可以合并两个Predicate并传入
		Predicate<String> startsWithJ = (n) -> n.startsWith("J");
		Predicate<String> fourLetterLong = (n) -> n.length() == 4;
		List<String> names = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
		names.stream().filter(startsWithJ.and(fourLetterLong))
				.forEach((n) -> System.out.println("nName, which starts with 'J' and four letter long is : " + n));
		names.stream().filter(startsWithJ.or(fourLetterLong))
				.forEach((n) -> System.out.println("nName, which starts with 'J' or four letter long is : " + n));
	}
	
	
	/***
	 * 例6、Java 8中使用lambda表达式的Map和Reduce示例
	 */
	@Test
	public void test5() {
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
	}
	
	
	/***
	 * 例7、通过过滤创建一个String列表
	 */
	@Test
	public void test6() {
		// 创建一个字符串列表，每个字符串长度大于2
		List<String> strList = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp", "C");
		List<String> filtered = strList.stream().filter(x -> x.length()> 2).collect(Collectors.toList());
		System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
	}
	
	
	/***
	 * 例8、对列表的每个元素应用函数
	 */
	@Test
	public void test7() {
		// 将字符串换成大写并用逗号链接起来
		List<String> G7 = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.","Canada");
		String G7Countries = G7.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", ", "[", "]"));
		System.out.println(G7Countries);
	}
	
	/***
	 * 例9、复制不同的值，创建一个子列表
	 */
	@Test
	public void test8() {
		// 用所有不同的数字创建一个正方形列表
		List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
		List<Integer> distinct = numbers.stream().map(i -> i * i).distinct().collect(Collectors.toList());
		System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
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
