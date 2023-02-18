package com.example.demo.user;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    
    @Autowired
    private JdbcTemplate jdbcTemplate;
    
    public List<Map<String, Object>> findAll() {
        String query = "select * from users;";
        List<Map<String, Object>> users = jdbcTemplate.queryForList(query);
        return users;
    }

    public boolean createUserRecord(User user) {
        String query = "insert into users(name, belong_to) values(?, ?)";
        jdbcTemplate.update(query, user.getName(), user.getBelongTo());
        return true;
    }
}
