package com.seabattle.SeaBattle.controller;

import com.seabattle.SeaBattle.ActiveGame;
import com.seabattle.SeaBattle.entity.Ship;
import com.seabattle.SeaBattle.entity.User;
import com.seabattle.SeaBattle.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("getInfo")
    public ActiveGame gameInfo(@RequestBody ActiveGame activeGame, @RequestBody User user){
        return userService.getInfo(activeGame, user);
    }

    @GetMapping("berega")
    public List<Ship> berega(){
        return userService.berega();
    }

    @GetMapping("halfField")
    public List<Ship> halfField(){
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

    @PostMapping("findGame")
    public ActiveGame newGame(@RequestBody int[][] fieldUser, @RequestBody User user){
        return  userService.newGame(user, fieldUser);
    }

    @GetMapping("fire")
    public String fire(@RequestBody ActiveGame activeGame, @RequestBody int[] cord, @RequestBody User user){
        return userService.fire(activeGame, cord, user);
    }

    @PostMapping("addRating{id}")
    public void addRating(@RequestParam int id, @RequestBody int rating){
        userService.addRating(id, rating);
    }

    @GetMapping("users")
    public List<User> getAllUsers(){
        return userService.readAllUserRating();
    }
}
