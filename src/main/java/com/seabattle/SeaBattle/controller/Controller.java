package com.seabattle.SeaBattle.controller;

import com.seabattle.SeaBattle.ActiveGame;
import com.seabattle.SeaBattle.entity.User;
import com.seabattle.SeaBattle.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<User> auth(@RequestBody User user){
        User authUser = userService.auth(user.getLogin(), user.hashCodePassword());
        if(authUser!=null)
            return new ResponseEntity<>(authUser, HttpStatus.OK);
        else
            return new ResponseEntity<>(null, HttpStatus.I_AM_A_TEAPOT);
    }

    @GetMapping("berega")
    public int[][] berega(){
        return userService.berega();
    }

    @GetMapping("halfField")
    public int[][] halfField(){
        return userService.halfField();
    }

    @PostMapping("register")
    public User register(@RequestBody User user){
        return userService.create(user);
    }

    @PutMapping("update")
    public void update(@RequestBody User user){
        userService.update(user);
    }

    @PostMapping("newGameWithII")
    public ActiveGame newGameWithII(@RequestBody int[][] fieldUser, @RequestBody User user){
        return  userService.newGameWithII(user, fieldUser);
    }

    @GetMapping("fire")
    public ActiveGame fire(@RequestBody ActiveGame activeGame, @RequestBody int[] cord){
        return userService.fire(activeGame, cord);
    }
}
