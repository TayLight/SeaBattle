package com.seabattle.SeaBattle.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private int userId;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private char[] password;
    @Column(name = "secret_word")
    private String secretWorld;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private Rating rating;
}
