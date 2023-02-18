package com.example.demo.user;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class User {
    private int id;
    private String name;
    private int belongTo;
    private LocalDateTime joinedAt;
    private LocalDateTime loginAt;
}
