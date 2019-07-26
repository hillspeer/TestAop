package com.test.aop;

import lombok.Data;

import com.test.aop.Calculator.Result;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

    @Autowired Test test;

    @Autowired Calculator calculator;

    @RequestMapping("/")
    String hello() {
        System.out.println("Hello World");
        test.test();
        return "Hello World!";
    }

    

    // SQL sample
    @RequestMapping("calc")
    Result calc(@RequestParam int left, @RequestParam int right) {
        return calculator.calc();
    }
}
