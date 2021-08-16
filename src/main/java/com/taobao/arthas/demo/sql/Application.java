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

@SpringBootApplication
@EnableScheduling
public class Application {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Scheduled(fixedDelay = 5000)
    public void executeSql() {
        System.out.println("=============" + LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
        System.out.println("executing com.taobao.arthas.demo.sql: select * from org_user");
        jdbcTemplate.query("select * from org_user", new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        });

        System.out.println("executing com.taobao.arthas.demo.sql: select * from org_user where age <= ?");
        jdbcTemplate.query("select * from org_user where age <= ?", new Object[]{18}, new RowMapper<Object>() {
            @Override
            public Object mapRow(ResultSet resultSet, int i) throws SQLException {
                return null;
            }
        });

        System.out.println("executing com.taobao.arthas.demo.sql: update org_user set age = age + ?");
        jdbcTemplate.update("update org_user set age = age + ?", new Object[]{1});
    }
}
