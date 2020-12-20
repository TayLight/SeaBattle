package com.seabattle.SeaBattle;

import com.seabattle.SeaBattle.entity.User;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.util.Random;

@EqualsAndHashCode(callSuper = false)
public class ActiveGame {
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

    public ActiveGame(User user, int[][] fieldUser) {
        user1 = user;
        field1 = fieldUser;
        round = 0;
        status = "Ожидание игрока 2";
    }

    public String setUser2(User user, int[][] fieldUser) {
        user2 = user;
        field2 = fieldUser;
        round = 0;
        status = "Раунд 1";
        return status;
    }

    public String fire(int[] cord, User user) {
        if (countShips1 != 0 || countShips2 != 0) {
            if (user.getUserId() == user1.getUserId() && whoTurn.equals(user1)) {
                int result = field2[cord[0]][cord[1]];
                switch (result) {
                    case 0:
                        return "Мимо";
                    case 1:
                        field2[cord[0]][cord[1]] = 4;
                        if (isGameEnd(user2)) {
                            return "Победа игрока 1";
                        }
                        return "Попадание";
                    case 2:
                        return "Клетка рядом с кораблем";
                    case 4:
                        return "Уже обстрелянная клетка";
                }
            } else if (user.getUserId() == user2.getUserId() && whoTurn.equals(user2)) {
                int result = field2[cord[0]][cord[1]];
                switch (result) {
                    case 0:
                        return "Мимо";
                    case 1:
                        field1[cord[0]][cord[1]] = 4;
                        if (isGameEnd(user1)) {
                            return "Победа игрока 2";
                        }
                        return "Попадание";
                    case 2:
                        return "Клетка рядом с кораблем";
                    case 4:
                        return "Уже обстрелянная клетка";
                }
            } else if (user.getUserId() == user2.getUserId() && whoTurn.equals(user1)) {
                return "Не твой ход";
            } else if (user.getUserId() == user1.getUserId() && whoTurn.equals(user2)) {
                return "Не твой ход";
            }
        } else {
            if (countShips1 == 0) {
                return "Победа игрока 2";
            } else {
                return "Победа игрока 1";
            }
        }
        return null;
    }

    private boolean isGameEnd(User user) {
        if (user.equals(user1)) {
            int count = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (field1[i][j] == 4) {
                        count++;
                    }
                }
            }
            return count == 20;
        } else {
            int count = 0;
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (field1[i][j] == 4) {
                        count++;
                    }
                }
            }
            return count == 20;
        }
    }
}
