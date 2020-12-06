package com.seabattle.SeaBattle.main;

import com.seabattle.SeaBattle.entity.User;

import java.util.Arrays;

public class Test {

    public static void main(String[] arg){
        User user = new User();
        user.setPassword("DenisPassword");
        System.out.println(Arrays.toString(user.hashCodePassword()));
    }
}
