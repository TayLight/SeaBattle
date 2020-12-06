package com.seabattle.SeaBattle.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import javax.persistence.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;

@Entity
@Data
@Table(name="user", schema = "public")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class User {

    @Id
    @GeneratedValue
    @Column(name = "id_user")
    private int userId;
    @Column(name = "login")
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "secret_word")
    private String secretWorld;
    @OneToOne(optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user")
    private Rating rating;

    public byte[] hashCodePassword(){
        try {
            SecureRandom random = new SecureRandom();
            byte[] salt = new byte[16];
            KeySpec spec = new PBEKeySpec(password.toCharArray(),salt , 65536, 128);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
            byte [] result = factory.generateSecret(spec).getEncoded();
            System.out.println(Arrays.toString(result));
            return result;
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            e.printStackTrace();
        }
        return null;
    }
}
