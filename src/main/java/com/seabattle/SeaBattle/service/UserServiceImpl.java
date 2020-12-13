package com.seabattle.SeaBattle.service;

import com.seabattle.SeaBattle.ActiveGame;
import com.seabattle.SeaBattle.entity.User;
import com.seabattle.SeaBattle.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private List<User> activeUser = new LinkedList<>();
    private List<ActiveGame> activeGames = new LinkedList<>();

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> readAllUser() {
        return userRepository.findAll();
    }

    @Override
    public User read(int userId) {
        return userRepository.getOne(userId);
    }

    @Override
    public void update(User user, int userId) {
        user.setUserId(userId);
        userRepository.save(user);
    }

    @Override
    public void delete(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public User auth(String login, byte[] hash) {
        User user  = userRepository.findUserByLogin(login);
        System.out.println(login+" = " + user.getLogin());
        if(Arrays.equals(user.hashCodePassword(), hash)) {
            System.out.println("true");
            return user;
        }
        else{
            System.out.println("false");
            return null;
        }
    }

    public ActiveGame startGameWithSkynet(User user){
        return new ActiveGame(user);
    }

}
