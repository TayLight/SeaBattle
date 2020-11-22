package com.seabattle.SeaBattle.repo;

import com.seabattle.SeaBattle.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
