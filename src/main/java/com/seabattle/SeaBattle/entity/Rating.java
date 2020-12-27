package com.seabattle.SeaBattle.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jdk.jfr.Enabled;
import lombok.Data;
import com.seabattle.SeaBattle.entity.User;

import javax.persistence.*;

@Entity
@Table(name = "rating", schema = "public")
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", ""})
public class Rating {

    @Id
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
