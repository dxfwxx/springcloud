package com.springcloud.cn.singleton;

/**
 * 懒汉式 同步延迟加载 -synchronized方法
 *      保证了对临界资源的同步互斥访问，也就保证了单例
 *          但是这种实现方式的运行效率会很低，因为同步块的作用域有点大，而且锁的粒度有点粗
 */

public class Singleton3 {

    private static Singleton3 singleton3;

    private Singleton3() {}

    // 使用 synchronized 修饰，临界资源的同步互斥访问
    private synchronized Singleton3 getSingleton3() {
        if(singleton3 == null) {
            return new Singleton3();
        }
        return singleton3;
    }
}
