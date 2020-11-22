package com.seabattle.SeaBattle.controller;

import com.seabattle.SeaBattle.entity.User;
import com.seabattle.SeaBattle.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping
    public List<User> readAllUser(){
        User user = new User();
        user.setLogin("login");
        List<User> list = new LinkedList<User>();
        list.add(user);
        return list;
    }
}
