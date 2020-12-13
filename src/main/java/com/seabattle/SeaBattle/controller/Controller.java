package com.seabattle.SeaBattle.controller;

import com.seabattle.SeaBattle.entity.User;
import com.seabattle.SeaBattle.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;
import java.util.List;

@RestController
@RequestMapping()
public class Controller {
    private final UserServiceImpl userService;

    @Autowired
    public Controller(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("all")
    public List<User> readAllUser(){
        return userService.readAllUser();
    }

    @PostMapping("auth")
    public User auth(@RequestBody User user){
        return userService.auth(user.getLogin(), user.hashCodePassword());
    }

    @PostMapping("register")
    public User register(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("update")
    public void update(@RequestBody User user){
        userService.update(user);
    }
}
