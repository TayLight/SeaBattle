package com.seabattle.SeaBattle.entity;

import lombok.Data;

@Data
public class NodeRating {
    private String login;
    private int score;

    public NodeRating(String login, int score) {
        this.login = login;
        this.score = score;
    }
}
