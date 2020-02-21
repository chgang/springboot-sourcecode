package com.qskx.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: Teacher
 * @Author: cg
 * @CreateDate: 2020-01-06 22:52
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
@Component
public class Teacher {
    @Autowired
    private Student student;
    public void teach() {
        student.add("");
    }
    public void work() {
        System.out.println("老师在工作。。。");
        student.add("");
    }
}
