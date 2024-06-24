package com.nelseniq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/health")
public class HealthCheckController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @GetMapping("/db")
    public String checkDatabaseConnection() {
        try {
            jdbcTemplate.execute("SELECT 1");
            return "Database is connected";
        } catch (Exception e) {
            return "Database is NOT connected: " + e.getMessage();
        }
    }
}
