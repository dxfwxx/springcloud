package com.springcloud.cn.proxy.cgolib;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class HelloMothodInterceptor implements MethodInterceptor{

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("before: " + method.getName());
        Object object = methodProxy.invokeSuper(o, objects);
        System.out.println("after: " + method.getName());
        return object;
    }
}
