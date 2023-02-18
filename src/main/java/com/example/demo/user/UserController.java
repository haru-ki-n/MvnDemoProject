package com.example.demo.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    
    @Autowired
    private UserService service;

    @GetMapping("")
    private String getUser(Model model) {
        List<User> users = service.getUsers();
        for (var user : users) {
            System.out.println(user.getName());
        }
        model.addAttribute("users", users);

        return "user/index";
    }

    @GetMapping("/create")
    private String createUser(){

        return "user/create";
    }

    @PostMapping("/create-confirm")
    public String createConfirmUser(@RequestParam("userName") String v, Model model) {
        model.addAttribute("confirmName", v);

        return "user/create-confirm";
    }

    @PostMapping("/create-complete")
    public String createCompleteUser(@RequestParam("userName") String name, Model model) {
        service.createUser(name);
        return "redirect:/user";
    }
}
