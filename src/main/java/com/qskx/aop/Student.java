package com.qskx.aop;

import org.springframework.stereotype.Component;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: Student
 * @Author: cg
 * @CreateDate: 2020-01-02 16:06
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */
@Component
public class Student {

    public String add(String name) {
        System.out.println(">>>>>>>>>>>> 添加一个学生。。。");
        return "";
    }

    public void delete() {
        System.out.println(">>>>>>>>>>>> 删除一个学生。。。");
    }
}
