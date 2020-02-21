package com.qskx.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: DaoProxy
 * @Author: cg
 * @CreateDate: 2020-01-07 14:32
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class DaoProxy implements MethodInterceptor {
    /**
     * Object：cglib生成的代理对象
     * Method：被代理对象的方法
     * Object[]：方法参数
     * MethodProxy：代理对象的方法
     */

    @Override
    public Object intercept(Object object, Method method, Object[] objects, MethodProxy proxy) throws Throwable {
        System.out.println("Before Method Invoke");
        proxy.invokeSuper(object, objects);
        System.out.println("After Method Invoke");

        return object;
    }
}
