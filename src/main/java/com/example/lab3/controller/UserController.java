package com.example.lab3.controller;

import com.example.lab3.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@RestController
public class UserController {
    @Autowired
    private NamedParameterJdbcTemplate jdbcTemplate;

    @GetMapping(path = "/api/users")
    public List<User> getUser() {
        return jdbcTemplate.query("""
                select * from users
                """, this::mapRow);
    }

    private User mapRow(ResultSet rs, int rowNum) throws SQLException {
        User user = new User();
        user.setId(rs.getLong("id"));
        user.setName(rs.getString("name"));
        user.setAge(rs.getInt("age"));
        return user;
    }
}
