package com.seabattle.SeaBattle;

import com.seabattle.SeaBattle.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@EqualsAndHashCode(callSuper = false)
public class ActiveGame   {
    private String status;
    private boolean inGame = true;
    private User user1;
    private User user2;
    private Random random;
    private  int round;
    private User gamer1;
    private User gamer2;
    private int countShips1;
    private int countShips2;
    private User whoTurn;
    private boolean inRound;
    @Getter
    @Setter
    private int[][] field1;
    @Getter
    @Setter
    private int[][] field2;

    public ActiveGame(User user){
        this.user1 = user;
        status = "Ждем второго игрока";
    }

    public ActiveGame(User user1, User user2) {
        this.user1 = user1;
        this.user2 = user2;
        random = new Random();
        round=0;
    }

    public ActiveGame(User user1, int[][] fieldUser) {
        this.user1 = user1;
        user2 = new SkyNet(this);
        random = new Random();
        field1= fieldUser;
        GameUntil gameUntil = new GameUntil();
        field2 = gameUntil.fullField();
        round=0;
        countShips1=10;
        countShips2=10;

        int rand = 1 + (int) (Math.random() * 2);
        if(rand == 1) {
            whoTurn = user1;
            status="Ход игрока 1";
        }
        else
            whoTurn= user2;
    }



    public String fire(int[] cord, User user){
        if(countShips1!=0||countShips2!=0) {
            if (user.getUserId() == user1.getUserId() && whoTurn.equals(user1)) {
                if (!(field2[cord[0]][cord[1]] == 0) && !(field2[cord[0]][1] == 5)) {
                    int result = field2[cord[0]][cord[1]];
                    switch (result){
                        case 1:
                            countShips2--;
                            if (countShips2 != 0) {
                                return "Убит однопалубный корабль";
                            } else return "Победа игрока 2";
                        case 2:

                            countShips2--;
                            return "Попадание";
                        case 3:
                            countShips2--;
                            return "Попадание";
                        case 4:
                            countShips2--;
                            return "Попадание";
                        case 5:
                            countShips2--;
                            return "Промах";
                    }
                } else{
                    whoTurn= user2;
                    round++;
                    status="Ход игрока 2";
                    return "Промах";
                }
            } else if (user.getUserId() == user2.getUserId() && whoTurn.equals(user2)) {
                if (!(field1[cord[0]][cord[1]] == 0) && !(field1[cord[0]][1] == 5)) {
                    return "Попадание";
                } else {
                    whoTurn = user1;
                    status = "Ход игрока 2";
                    round++;
                    return "Промах";}
            } else if (user.getUserId() == user2.getUserId() && whoTurn.equals(user1)) {
                return "Не твой ход";
            } else if (user.getUserId() == user1.getUserId() && whoTurn.equals(user2)) {
                return "Не твой ход";
            }
        } else {
            if(countShips1==0){
                return "Победа игрока 2";
            } else {
                return "Победа игрока 1";
            }
        }
        return null;
    }

    
}
