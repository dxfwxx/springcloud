package com.test.inner;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
class Animal{
	
	private String name = "animal";
	
	private int a = 10;
	
	// 1. 外部类修饰符 public default  内部类修饰符 public/private/default/protected
	public class Head {
		String name = "head";
		public void print(int x){
			// 2. 访问外部类成员
			System.out.println(a);
			
			// 5.访问值
//			String name = "print";
			System.out.println(name);
			System.out.println(this.name);
			System.out.println(Animal.this.name);
			
			System.out.println(x);
		}
	}
	protected class Hand{
		public void print() {
			System.out.println("hand");
		}
	}
	private class Foot{
		int b = 20;
		public void print() {
			System.out.println("foot");
		}
	}
	
	public void print() {
		// 3.在外部类中访问内部类成员
		Foot foot = new Foot();
		System.out.println(foot.b);
		foot.print();
	}
}
class Dog extends Animal {
	
	public void print() {
		new Hand().print();
		System.out.println("---------");
		
		new Head().print(10);
		System.out.println("---------");
		
		super.print();
	}
}
public class MemberInnerTest {
	public static void main(String[] args) {
		Animal animal = new Animal();
//		animal.print();
//		System.out.println("---------");
		
		// 4.创建内部类对象
		Animal.Head head = animal.new Head();
		head.print(10);
		System.out.println("---------");
//
//		Animal dog = new Dog();
//		dog.print();
	}
}
