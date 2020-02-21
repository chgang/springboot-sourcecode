package com.qskx.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: springbootRunTest
 * @Author: cg
 * @CreateDate: 2019-12-19 14:07
 * @Version: 1.0
 * Copyright: Copyright (c) 2019
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.qskx.*")
@EnableFeignClients(basePackages = "com.qskx.*")
public class SpringbootRunTest {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRunTest.class, args);
    }
}
