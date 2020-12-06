package com.seabattle.SeaBattle;

import com.seabattle.SeaBattle.entity.User;

import java.time.LocalDate;

public class Game {
    private int id;
    private User user1;
    private User user2;

    public Game(User user1, User user2) {
        this.id = LocalDate.now().hashCode();
        this.user1 = user1;
        this.user2 = user2;
    }


}
