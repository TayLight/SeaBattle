package com.seabattle.SeaBattle;

import com.seabattle.SeaBattle.entity.User;

import java.util.Random;

public class ActiveGame extends Thread {
    private boolean inGame = true;
    private User user1;
    private User user2;
    private Random random;
    private  int round;
    private User gamer1;
    private User gamer2;
    private boolean inRound;
    private int[][] field1;
    private int[][] field2;

    public ActiveGame(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        random = new Random();
        round=0;
    }

    public ActiveGame(User user1) {
        this.user1 = user1;
        user2 = new SkyNet(this);
        random = new Random();
        round=0;
    }

    @Override
    public void run() {
        while(inGame) {
            if (round == 0){
                int coin = 1 + (int) (Math.random() * 2);
                if (coin == 1) {
                    gamer1=user1;
                    gamer2=user2;
                } else {
                    gamer1 = user2;
                    gamer2=user1;
                }
                gamer1.setCountShips(10);
                gamer2.setCountShips(10);
                round++;
            }
            gamer1.nextRound();
            gamer2.nextRound();
            if(gamer1.getCountShips()==0){
                gamer2.win(round);
                gamer1.lose(round);
                inGame=false;
            }
            else if(gamer2.getCountShips()==0){
                gamer2.lose(round);
                gamer1.lose(round);
                inGame=false;
            }
            round++;
        }
    }
}
