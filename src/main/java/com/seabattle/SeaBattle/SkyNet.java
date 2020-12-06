package com.seabattle.SeaBattle;

import com.seabattle.SeaBattle.entity.User;

public class SkyNet extends User {
    private ActiveGame game;

    public SkyNet(ActiveGame game) {
        this.game = game;
    }

    public void find(){
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                boolean result = shoot(i,j);
            }
        }
    }

    public boolean shoot(int i, int  j){
        boolean result=false;
        //game.shoot(this, i, j);
        return result;
    }
}
