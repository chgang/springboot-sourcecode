package com.qskx.proxy.cglib;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: TargetObject
 * @Author: cg
 * @CreateDate: 2020-01-07 11:28
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class TargetObject {

    public void method1(String paramName) {
        System.out.println(paramName);
    }

    public int method2(int count) {
        return count;
    }

    public int method3(int count) {
        return count;
    }

    @Override
    public String toString() {
        return "TargetObject []"+ getClass();
    }
}
