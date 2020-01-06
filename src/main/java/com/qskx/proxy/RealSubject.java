package com.qskx.proxy;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: RealSubject
 * @Author: cg
 * @CreateDate: 2020-01-06 13:49
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class RealSubject implements Subject, Feature {

    @Override
    public void doSomething() {
        System.out.println("fly...");
    }

    @Override
    public void fly() {
        System.out.println("自由飞翔...");
    }
}
