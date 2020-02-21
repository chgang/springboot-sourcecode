package com.qskx.importSelector;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: EnableHelloWorldBootstrap
 * @Author: cg
 * @CreateDate: 2020-01-11 15:19
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
@EnableHelloWorld
public class EnableHelloWorldBootstrap {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = new SpringApplicationBuilder(EnableHelloWorldBootstrap.class)
                .web(WebApplicationType.NONE)
                .run(args);

        // helloWorld Bean 是否存在
        String helloWorld = context.getBean("helloWorld", String.class);
        System.out.println("helloWorld Bean : " + helloWorld);
        // 关闭上下文
        context.close();
    }

}
