package com.test.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Test{

    @Autowired Calculator calculator;

    public void test(){
        System.out.println("Test");
        calculator.calc();
    }
}