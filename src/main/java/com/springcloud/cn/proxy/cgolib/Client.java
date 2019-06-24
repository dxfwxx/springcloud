package com.springcloud.cn.proxy.cgolib;

import net.sf.cglib.proxy.Enhancer;

public class Client {
    public static void main(String[] args) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloServiceImpl.class);
        enhancer.setCallback(new HelloMothodInterceptor());
        HelloServiceImpl helloService = (HelloServiceImpl) enhancer.create();
        helloService.sayHello();
    }
}
