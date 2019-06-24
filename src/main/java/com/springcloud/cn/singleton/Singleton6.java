package com.springcloud.cn.singleton;

/**
 * 为了在保证单例的前提下提高运行效率，我们需要对 singleton3 进行第二次检查，
 * 目的是避开过多的同步（因为这里的同步只需在第一次创建实例时才同步，一旦创建成功，以后获取实例时就不需要同步获取锁了
 *
 * 必须使用volatile关键字修饰单例引用。
 */
public class Singleton6 {

    private static volatile Singleton6 singleton6;

    private Singleton6() {}

    private static Singleton6 getSingleton6() {
        if (singleton6 == null) {
            synchronized (Singleton6.class) {
                // 只需在第一次创建实例时才同步
                if (singleton6 == null) {
                    singleton6 = new Singleton6();
                }
            }
        }
        return singleton6;
    }
}
