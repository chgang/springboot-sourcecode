package com.qskx.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: ProxyHandler
 * @Author: cg
 * @CreateDate: 2020-01-06 14:10
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class ProxyHandler implements InvocationHandler {

    private Object target;

    public Object bind(Object target){
        this.target = target;
        // 绑定该类实现的所有接口，取得代理类
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // 在调用具体函数方法前，执行功能处理
        System.out.println("before.");
        // 反射执行目标类的方法
        Object result = method.invoke(target,args);
        System.out.println("after.");
        // 在调用具体函数方法后，执行功能处理
        return result;
    }

    public static void main(String[] args) {
        // 保存生成的代理类的字节码文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        ProxyHandler proxy = new ProxyHandler();
        // 绑定该类实现的所有接口
        Subject sub = (Subject) proxy.bind(new RealSubject());
        sub.doSomething();
        Feature feature = (Feature) proxy.bind(new RealSubject());
        feature.fly();
    }
}
