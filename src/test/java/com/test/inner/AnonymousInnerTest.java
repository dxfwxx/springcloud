package com.test.inner;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */

class AnonymousOuter {
	/***
	 * ---------匿名内部类----------
	 *       (1) 继承式的匿名内部类
	 *       (2) 接口式的匿名内部类
	 *       (3) 参数式的匿名内部类
	 *    注意:
	 *       (1) 不能有构造方法，只能有一个实例
	 *       (2) 不能定义任何静态成员、静态方法(依赖对象)
	 *       (3) 不能是public/private/protected/static
	 *       (4) 一定是在new的后面，用其隐含实现一个接口或继承一个类
	 *       (5) 匿名内部类为局部的，所以局部内部列的所有限制都对其生效
	 *  继承式
	 */
	public void print1() {
		new Cat() {
			public void eat() {
				System.out.println("cat is eating");
			}
		}.eat();
	}
	/***
	 *  接口式
	 */
	public void print2() {
		new Eat() {
			public void eat() {
				System.out.println("cat is eating");
			}
		}.eat();
	}
	/***
	 *  参数式
	 */
	public void print3(Eat eat) {
		eat.eat();
	}
}
public class AnonymousInnerTest {
	
	public static void main(String[] args) {
		AnonymousOuter outer = new AnonymousOuter();
		
		// 匿名内部类
		outer.print1();
		outer.print2();
		outer.print3(new Eat() {
			@Override
			public void eat() {
				System.out.println("cat is eating");
			}
		});
	}
}
