package com.qskx.importSelector;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: HelloWorldImportSelector
 * @Author: cg
 * @CreateDate: 2020-01-11 15:16
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
public class HelloWorldImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        //返回上面定义的Configuration类全称
        return new String[]{HelloWorldConfiguration.class.getName()};
    }

}
