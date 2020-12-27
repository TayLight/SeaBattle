package com.seabattle.SeaBattle.repo;

import com.seabattle.SeaBattle.entity.Rating;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RatingRepository extends JpaRepository<Rating, Integer> {
}
