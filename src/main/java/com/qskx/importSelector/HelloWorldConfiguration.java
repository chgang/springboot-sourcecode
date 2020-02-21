package com.qskx.importSelector;

import org.springframework.context.annotation.Bean;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: HelloWorldConfiguration
 * @Author: cg
 * @CreateDate: 2020-01-11 15:15
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class HelloWorldConfiguration {

    @Bean
    public String helloWorld() {
        return "Hello,World 2020";
    }
}
