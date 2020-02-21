package com.qskx.importSelector;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: EnableHelloWorld
 * @Author: cg
 * @CreateDate: 2020-01-11 15:17
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Import(HelloWorldImportSelector.class)
public @interface EnableHelloWorld {

}
