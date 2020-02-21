package com.qskx.proxy.cglib;

import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: TargetInterceptor
 * @Author: cg
 * @CreateDate: 2020-01-07 11:34
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class TargetInterceptor implements MethodInterceptor {

    @Override
    public Object intercept(Object obj, Method method, Object[] params,
                            MethodProxy proxy) throws Throwable {
        System.out.println("调用前");
        Object result = proxy.invokeSuper(obj, params);
//        System.out.println(" 调用后"+result);
        return result;
    }
}
