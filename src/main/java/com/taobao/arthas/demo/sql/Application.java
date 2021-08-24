package com.taobao.arthas.demo.sql;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
@EnableScheduling
public class Application {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Scheduled(fixedDelay = 10000)
    public void executeSql() {
        System.out.println("=============" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("executing sql: select * from org_user");
        jdbcTemplate.query("select * from org_user", new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        });

        System.out.println("executing sql: select * from org_user where age <= ?");
        jdbcTemplate.query("select * from org_user where age <= ?", new Object[]{18}, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        });

        System.out.println("executing sql: update org_user set age = age + ?");
        jdbcTemplate.update("update org_user set age = age + ?", new Object[]{1});

        System.out.println("executing sql: update org_user set age = age + 1;update org_user set age = age - 1");
        jdbcTemplate.batchUpdate("update org_user set age = age + 1",
                "update org_user set age = age - 1");

        System.out.println("executing sql: update org_user set age = age + ? args: (10), (20)");
        jdbcTemplate.batchUpdate("update org_user set age = age + ?",
                Arrays.asList(new Object[][]{new Object[]{10}, new Object[]{20}}));
    }
}
