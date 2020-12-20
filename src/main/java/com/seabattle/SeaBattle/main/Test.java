package com.seabattle.SeaBattle.main;

import com.seabattle.SeaBattle.GameUntil;
import com.seabattle.SeaBattle.entity.Ship;
import com.seabattle.SeaBattle.entity.User;

import java.util.Arrays;
import java.util.List;

public class Test {

    public static void main(String[] arg){
       GameUntil gameUntil = new GameUntil();
        for (Ship ship: gameUntil.berega()) {
            System.out.println(ship);
        }
    }
}
