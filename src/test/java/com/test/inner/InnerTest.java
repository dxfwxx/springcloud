package com.test.inner;

/**
 * @author dxf@choicesoft.com.cn
 *
 * 1.成员内部类: 在类中定义一个类  老板和秘书的关系
 *
 * 2.方法内部类: 在类的的方法中定义一个类
 *        (1) 方法内部类只能在定义改内部类的方法内实例化，不可以在此方法外对其实例化。
 *        (2) 方法内部类对象不能使用该内部来所在方法的非final局部变量。
 *
 * 3.静态内部类: 在类内部定义一个静态类(封装的作用)
 *        (1) 如同静态变量一样，不需要依赖外部类对象
 *        (2) 静态内部类只能访问外部类的静态变量或静态方法
 *
 * 4.匿名内部类:
 *        (1) 继承式的匿名内部类
 *        (2) 接口式的匿名内部类
 *        (3) 参数式的匿名内部类
 *     注意:
 *        (1) 不能有构造方法，只能有一个实例
 *        (2) 不能定义任何静态成员、静态方法(依赖对象)
 *        (3) 不能是public/private/protected/static
 *        (4) 一定是在new的后面，用其隐含实现一个接口或继承一个类
 *        (5) 匿名内部类为局部的，所以局部内部列的所有限制都对其生效
 *
 *
 * 作用: 每一个内部类都能独立的继承自一个（接口的）实现，所以无论外部类是否已经继承某个（接口的）实现，对于内部类都没有影响，
 *      如果没有内部类提供的可以继承多个集体的或抽象的类的能力，一些设计与编程问题就很难解决。从这个角度讲，内部类使得多重继承的解决方案变得完整。
 *      接口解决了部分问题，而内部类有效的实现了"多重继承"。
 *
 *
 * 划分:
 *          成员:   成员内部类   静态内部类
 *          局部:   方法内部类   匿名内部类
 *
 *        依赖外部对象的内部类: 成员内部类、方法内部类、匿名内部类
 *        静态内部类不依赖外部类的对象，项目中优先考虑选择静态内部类（内存泄漏，内部类的生命周期比较长时，外部类内存无法释放）
 */

interface Eat{
	void eat();
}

abstract class Cat {
	abstract void eat();
}

class Outer {
	
	private String name;
	
	private static Integer age = 19;
	
	public Outer(String name) {
		this.name = name;
	}
	
	/**
	 * ----------成员内部类----------
	 *  建议在外部类中定义方法，对外提供内部类接口
	 */
	class Inner1 {
		public void print() {
			System.out.println("inner1  " + name);
		}
	}
	
	
	
	/**
	 * ---------方法内部类----------
	 *  show方法的局部变量或者方法的参数，实际上必须是常量 final
	 *      局部变量如果没有用final修饰，他的生命周期和方法的生命周期是一样的，当方法被调用时会入栈，调用结束后即弹栈，这个局部变量会随之消失，
	 *      那么如果局部内部类对象还没有马上消失想用这个局部变量，显然已经无法使用了，如果用final修饰会在类加载的时候进入常量池，即使方法弹栈，
	 *      常量池的常亮还在，也就可以继续使用了。
	 *  在jdk1.8 中取消了这个特性, 编译器默认为final
 	 */
	public void show() {
		class Inner2{
			public void print() {
				System.out.println("inner2  " + name);
			}
		}
		Inner2 inner2 = new Inner2();
		inner2.print();
	}
	
	
	/***
	 * ---------静态内部类----------
	 */
	static class Inner3 {
		public void print() {
			System.out.println("inner3  " + age);
		}
	}
	
	
	
	/***
	 * ---------匿名内部类----------
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
public class InnerTest {
	public static void main(String[] args) {
		
		Outer outer = new Outer("dongxuefei");
		
		Outer.Inner1 inner = outer.new Inner1(); // public
		inner.print();
		
		// 方法内部类
		outer.show();
		
		// 静态内部类
		Outer.Inner3 inner3 = new Outer.Inner3();
		inner3.print();
		
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
