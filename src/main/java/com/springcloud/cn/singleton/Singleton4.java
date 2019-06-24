package com.springcloud.cn.singleton;

/**
 * 懒汉式同步延迟加载 — synchronized块
 */

public class Singleton4 {

    private static Singleton4 singleton4;

    private Singleton4() {}

    public Singleton4 getSingleton4() {

        // 使用 synchronized 块，临界资源的同步互斥访问
        synchronized (Singleton4.class) {
            if(singleton4 == null) {
                return new Singleton4();
            }
            return singleton4;
        }
    }
}
