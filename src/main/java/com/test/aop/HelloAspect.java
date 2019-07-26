package com.test.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import lombok.Data;

@Aspect
@Component
public class HelloAspect{

    
    @Data
    static class Result {
        private final int left;
        private final int right;
        private final long answer;
        public Result(int left, int right, long answer){
            this.left = left;
            this.right = right;
            this.answer = answer;
        }
    }

    @Around("within(com.test.aop.Test)" )
    void beforeHello(ProceedingJoinPoint jp) throws Throwable{

        System.out.println("Start....");

        jp.proceed();
        System.out.println("End.....");

    }

    @Around("within(com.test.aop.Calculator)" )
    void beforeCalc(ProceedingJoinPoint jp) throws Throwable{

        System.out.println("Start calc....");
        
        jp.proceed();
        System.out.println("End calc.....");

    }

}