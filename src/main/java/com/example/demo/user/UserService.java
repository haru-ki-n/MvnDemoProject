package com.example.demo.user;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    
    @Autowired
    private UserRepository repo;

    public List<User> getUsers() {
        List<Map<String, Object>> querySet = repo.findAll();

        List<User> users = new ArrayList<>();
        for(var record: querySet) {
            var user = new User();
            user.setId((Integer)(record.get("id")));
            user.setName((String)record.get("name"));
            user.setBelongTo((Integer)record.get("belong_to"));
            user.setJoinedAt((LocalDateTime)record.get("joined_at"));
            user.setLoginAt((LocalDateTime)record.get("login_at"));
            users.add(user);
        }
        return users;
    }

    
    public boolean createUser(String userName) {

        var user = new User();
        user.setName(userName);
        user.setBelongTo(1);

        repo.createUserRecord(user);
        return true;
    }
}
