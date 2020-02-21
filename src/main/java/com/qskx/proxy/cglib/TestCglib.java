package com.qskx.proxy.cglib;

import org.springframework.cglib.proxy.Enhancer;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: TestCglib
 * @Author: cg
 * @CreateDate: 2020-01-07 11:43
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class TestCglib {

    public static void main(String args[]) {
        Enhancer enhancer =new Enhancer();
        enhancer.setSuperclass(TargetObject.class);
        enhancer.setCallback(new TargetInterceptor());
        TargetObject targetObject2=(TargetObject)enhancer.create();
        System.out.println(targetObject2);
        targetObject2.method1("mmm1");
        System.out.println(targetObject2.method2(100));
        System.out.println(targetObject2.method3(200));
    }
}
