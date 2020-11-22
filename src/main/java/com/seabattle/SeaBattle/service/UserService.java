package com.seabattle.SeaBattle.service;

import com.seabattle.SeaBattle.entity.User;

import java.util.List;

public interface UserService {

    User create(User user);

    List<User> readAllUser();

    User read(int userId);

    void update(User user, int userId);

    void delete(int userId);
}
