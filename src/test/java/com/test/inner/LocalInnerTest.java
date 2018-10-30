package com.test.inner;

/**
 * @author dxf@choicesoft.com.cn
 * @data
 */

class LocalOuter {
	public void show(int x) {
		class LocalInner implements Runnable{
			public void print() {
//				x++;
				System.out.println("LocalInner  " + x);
			}
			@Override
			public void run() {
				System.out.println("LocalInner is running");
			}
		}
		LocalInner inner = new LocalInner();
		inner.print();
		
		Thread thread = new Thread(inner);
		thread.start();
	}
}
public class LocalInnerTest {
	
	public static void main(String[] args) {
		LocalOuter outer = new LocalOuter();
		outer.show(2);
	}
}
