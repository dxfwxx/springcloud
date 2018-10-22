package com.test.inner;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class LocalInnerTest {
	public static void show(int x) {
		class Inner2{
			public void print() {
//				x++;
				System.out.println("inner2  " + x);
			}
		}
	}
	
	public static void main(String[] args) {
		show(2);
	}
}
