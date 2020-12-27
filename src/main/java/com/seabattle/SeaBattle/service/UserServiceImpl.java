package com.seabattle.SeaBattle.service;

import com.seabattle.SeaBattle.ActiveGame;
import com.seabattle.SeaBattle.GameUntil;
import com.seabattle.SeaBattle.entity.Rating;
import com.seabattle.SeaBattle.entity.Ship;
import com.seabattle.SeaBattle.entity.User;
import com.seabattle.SeaBattle.repo.RatingRepository;
import com.seabattle.SeaBattle.repo.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RatingRepository ratingRepository;
    private List<User> activeUser = new LinkedList<>();
    private List<ActiveGame> activeGames = new LinkedList<>();
    public static final Comparator<User> COMPARE_BY_RATING = (lhs, rhs) -> rhs.getRating().getScore() - lhs.getRating().getScore();

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
    public void update(User user) {
        User newUser = userRepository.findUserByLogin(user.getLogin());
        newUser.setPassword(user.getPassword());
        userRepository.save(newUser);
    }

    @Override
    public void delete(int userId) {
        userRepository.deleteById(userId);
    }

    @Override
    public ActiveGame getInfo(ActiveGame activeGame, User user) {
        for (ActiveGame actGame: activeGames) {
            if(actGame.getLocalDate().equals(activeGame.getLocalDate())){
                if(actGame.getWhoTurn().getLogin().equals(user.getLogin())){
                    return actGame;
                }
            }
        }
        return null;
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

    @Override
    public ActiveGame newGame(User user, int[][] fieldUser) {
        ActiveGame findGame = null;
        for(ActiveGame activeGame: activeGames) {
            if (activeGame.getStatus().equals("Жду второго игрока")) {
                findGame = activeGame;
            }
        }
        if(findGame == null) {
            ActiveGame newActiveGame = new ActiveGame(user, fieldUser);
            activeGames.add(newActiveGame);
            return newActiveGame;
        } else {
            findGame.setUser2(user, fieldUser);
            return findGame;
        }
    }

    @Override
    public String fire(ActiveGame activeGame, int[] cord, User user) {
        ActiveGame activeGame1 =  activeGames.get(activeGame.hashCode());
        for (ActiveGame actGame: activeGames) {
            if(actGame.getLocalDate().equals(activeGame.getLocalDate())){
                if(actGame.getWhoTurn().getLogin().equals(user.getLogin())){
                    activeGame1=actGame;
                }
            }
        }
        return activeGame1.fire(cord, user);
    }

    @Override
    public List<Ship> berega() {
        GameUntil gameUntil = new GameUntil();
        return gameUntil.berega();
    }

    @Override
    public List<Ship> halfField() {
        GameUntil gameUntil = new GameUntil();
        return gameUntil.halfField();
    }

    @Override
    public void addRating(int id, int rating) {
        Rating rating1 = ratingRepository.findById(id).get();
        rating1.setScore(rating1.getScore()+rating);
        ratingRepository.save(rating1);
    }

    @Override
    public List<User> readAllUserRating() {
        List<User> users =  userRepository.findAll();
        users.sort(Comparator.comparingInt(o -> -o.getRating().getScore()));
        return users;
    }


}
