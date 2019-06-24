package com.springcloud.cn.singleton;

/**
 * 懒汉式： 单例实例被延迟加载
 *      非线程安全： 会有多个线程同时进入 if (singleton2 == null) {…} 语句块的情形发生。
 */

public class Singleton2 {

    private static Singleton2 singleton2;

    private  Singleton2() {}

    public Singleton2 getSingleton2() {
        if(singleton2 == null) {
            return new Singleton2();
        }
        return singleton2;
    }
}
