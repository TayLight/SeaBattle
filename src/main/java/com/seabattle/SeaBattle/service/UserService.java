package com.seabattle.SeaBattle.service;

import com.seabattle.SeaBattle.ActiveGame;
import com.seabattle.SeaBattle.entity.Ship;
import com.seabattle.SeaBattle.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> readAllUser();

    User read(int userId);

    void update(User user);

    void delete(int userId);

    ActiveGame getInfo(ActiveGame activeGame, User user);

    User auth(String login, byte[] hash);

    ActiveGame newGame(User user, int[][] fieldUser);

    String fire(ActiveGame activeGame, int[] cord, User user);

    List<Ship> berega();

    List<Ship> halfField();
}
