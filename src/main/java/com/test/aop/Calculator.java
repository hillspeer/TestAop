package com.test.aop;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component
public class Calculator{


    @Autowired
    NamedParameterJdbcTemplate jdbcTemplate;

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
    
    public void test(){
        System.out.println("Test");
        calc();
    }

    Result calc(){
        MapSqlParameterSource source = new MapSqlParameterSource()
        .addValue("left", 1)
        .addValue("right", 2);
        return jdbcTemplate.queryForObject("SELECT :left + :right AS answer", source,
        (rs, rowNum) -> new Result(1, 2, rs.getLong("answer")));
    }
    
}