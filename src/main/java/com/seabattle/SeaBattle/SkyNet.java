package com.seabattle.SeaBattle;

import com.seabattle.SeaBattle.entity.User;

public class SkyNet extends User {
    private ActiveGame game;

    public SkyNet(ActiveGame game) {
        this.game = game;
    }

    public int[] find(){
        int[] resultCoord = new int[2];
        for(int i=0; i<10; i++){
            for(int j=0; j<10; j++){
                boolean result = shoot(i,j);
                if(result) {
                    resultCoord[0]=i;
                    resultCoord[1]=j;
                    return resultCoord;
                }
            }
        }
        for(int i=10; i>0; i--){
            for(int j=10; j>0; j--){
                boolean result = shoot(i,j);
                if(result) {
                    resultCoord[0]=i;
                    resultCoord[1]=j;
                    return resultCoord;
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
