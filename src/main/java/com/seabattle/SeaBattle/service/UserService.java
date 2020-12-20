package com.seabattle.SeaBattle.service;

import com.seabattle.SeaBattle.ActiveGame;
import com.seabattle.SeaBattle.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> readAllUser();

    User read(int userId);

    void update(User user);

    void delete(int userId);

    User auth(String login, byte[] hash);

    ActiveGame newGameWithII(User user, int[][] fieldUser);

    ActiveGame fire(ActiveGame activeGame, int[] cord);

    int[][] berega();

    int[][] halfField();
}
