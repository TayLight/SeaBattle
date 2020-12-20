package com.seabattle.SeaBattle;

import com.seabattle.SeaBattle.entity.User;

public class SkyNet extends User {
    private ActiveGame game;

    public SkyNet(ActiveGame game) {
        this.game = game;
        GameUntil gameUntil = new GameUntil();
        game.setField2(gameUntil.fullField());
    }

    public int[] find(){
        int[] resultCord = new int[2];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                boolean result = shoot(i,j);
                if(result) {
                    resultCord[0]=i;
                    resultCord[1]=j;
                    return resultCord;
                }
            }
        }
        for(int i=10; i>0; i--){
            for(int j=10; j>0; j--){
                boolean result = shoot(i,j);
                if(result) {
                    resultCord[0]=i;
                    resultCord[1]=j;
                    return resultCord;
                }
            }
        }
        return null;
    }

    public boolean shoot(int i, int  j){
        boolean result=false;
        //game.shoot(this, i, j);
        return result;
    }
}
