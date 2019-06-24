package com.springcloud.cn.singleton;

/**
 * 懒汉式同步延迟加载 — 使用内部类实现延迟加载
 *
 */
public class Singleton5 {

    // 私有内部类，按需加载，用时加载，也就是延迟加载
    private static class  Holder {
        private static Singleton5 singleton5 = new Singleton5();
    }

    private Singleton5() {}

    public static Singleton5 getSingleton5() {
        return Holder.singleton5;
    }

}
