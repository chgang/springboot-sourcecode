package com.qskx.proxy.cglib;

import org.springframework.cglib.core.DebuggingClassWriter;
import org.springframework.cglib.proxy.Enhancer;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: CglibTest
 * @Author: cg
 * @CreateDate: 2020-01-07 14:33
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class CglibTest {
    public static void main(String[] args) {

        // 生成的代理类文件存入本地磁盘
        System.setProperty(DebuggingClassWriter.DEBUG_LOCATION_PROPERTY, "./com/cglib");

        // 通过CGLIB动态代理获取代理对象的过程
        Enhancer enhancer = new Enhancer();
        // 设置enhancer对象的父类
        enhancer.setSuperclass(Dao.class);
        // 设置enhancer的回调对象
        enhancer.setCallback(new DaoProxy());

        // 创建代理对象
        Dao dao = (Dao)enhancer.create();
        // // 通过代理对象调用目标方法
        dao.update("yukang");
        dao.select();
    }
}
