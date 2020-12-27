package com.seabattle.SeaBattle.entity;

import jdk.jfr.Enabled;
import lombok.Data;
import com.seabattle.SeaBattle.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "Rating")
@Data
public class Rating {

    @Id
    @GeneratedValue
    @Column(name = "id_rating")
    private int ratingId;
    @Column(name = "score")
    private int score;

    public Rating() {
    }

    public Rating(int ratingId) {
        this.ratingId = ratingId;
    }

    public Rating(int userId, int i) {
        this.ratingId=userId;
        score=i;
    }
}
