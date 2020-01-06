package com.qskx.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @ProjectName: springboot-sourcecode
 * @ClassName: LogAspectAnnotation
 * @Author: cg
 * @CreateDate: 2020-01-02 16:03
 * @Version: 1.0
 * Copyright: Copyright (c) 2020
 */

@Aspect
@Component
public class LogAspectAnnotation {

    @Before("execution(public * com.qskx.aop.Student.add(..))")
    public void bBefore() {
        System.out.println("@@@前置通知");
    }
    @AfterReturning("execution(public * com.qskx.aop.Student.add(..))")
    public void bAfter() {
        System.out.println("@@@后置通知");
    }
    @AfterThrowing("execution(public * com.qskx.aop.Student.add(..))")
    public void bThrowing() {
        System.out.println("@@@异常通知");
    }

    //环绕通知 ,参数ProceedingJoinPoint
    @Around("execution(public * com.qskx.aop.Student.add(..))")
    public void myAround(ProceedingJoinPoint jp  ) {
        //方法之前：前置通知
        System.out.println("《【环绕】方法之前：前置通知");

        try {
            //方法执行时
            jp.proceed() ;//执行方法

            //方法之前之后：后置通知
            System.out.println("《【环绕】方法之前之后：后置通知");
        }catch(Throwable e) {
            //发生异常时：异常通知
            System.out.println("《【环绕】发生异常时：异常通知");
        }finally {
            //最终通知
            System.out.println("《【环绕】最终通知");
        }
    }

}
