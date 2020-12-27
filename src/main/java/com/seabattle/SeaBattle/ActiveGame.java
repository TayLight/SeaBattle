package com.seabattle.SeaBattle;

import com.seabattle.SeaBattle.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Random;

@EqualsAndHashCode(callSuper = false)
public class ActiveGame {
    @Getter
    @Setter
    private LocalDate localDate = LocalDate.now();
    @Setter
    @Getter
    private String status;
    private boolean inGame = true;
    private User user1;
    private User user2;
    private Random random;
    private int round;
    private User gamer1;
    private User gamer2;
    private int winCount1;
    private int winCount2;
    @Getter
    private User whoTurn;
    private boolean inRound;
    @Getter
    @Setter
    private int[][] field1;
    @Getter
    @Setter
    private int[][] field2;

    public ActiveGame(User user, int[][] fieldUser) {
        user1 = user;
        field1 = fieldUser;
        round = 0;
        winCount1=20;
        winCount2=20;
        status = "Ожидание игрока 2";
    }

    public String setUser2(User user, int[][] fieldUser) {
        user2 = user;
        field2 = fieldUser;
        round = 0;
        whoTurn=user2;
        status = "Ход "+ user2;
        winCount1=20;
        winCount2=20;
        return status;
    }

    public String fire(int[] cord, User user) {
        if (!isWin()) {
            if (user.getUserId() == user1.getUserId() && whoTurn.equals(user1)) {
                if(user.equals(whoTurn)){
                    if(whoTurn.equals(user1)){
                        if(field2[cord[0]][cord[1]]!=0){
                            field2[cord[0]][cord[1]]=5;
                            winCount2--;
                            if(isWin()){
                                status ="Победа " + user.getLogin();
                                return "Победа " + user.getLogin();
                            }
                            return "Попадание";
                        } else {
                            whoTurn=user2;
                            status="Ход "+user2.getLogin();
                            return "Промах";
                        }
                    }else if(whoTurn.equals(user2)){
                        if(field1[cord[0]][cord[1]]!=0){
                            field1[cord[0]][cord[1]]=5;
                            winCount1--;
                            if(isWin()){
                                status ="Победа " + user.getLogin();
                                return "Победа " + user.getLogin();
                            }
                            return "Попадание";
                        } else {
                            whoTurn=user1;
                            status="Ход "+user1.getLogin();
                            return "Промах";
                        }
                    } else return "Читер";
                } else return "Не твой ход";
            }
        }
        return null;
    }

    private boolean isWin(){
        if(winCount1==0 || winCount2== 0){
            if(winCount1==0){
                status="Победа "+ user1.getLogin();
                return true;
            }else {
                status="Победа "+ user2.getLogin();
                return true;
            }
        }
        else return false;
    }
}
