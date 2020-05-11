package com.test.inner;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */
public class InnerTest2 {
	interface Inner {
		void print();
	}
	public static void main(String[] args) {
		Inner inner = new Inner() {
			@Override
			public void print() {
			
			}
		};
	}
}
