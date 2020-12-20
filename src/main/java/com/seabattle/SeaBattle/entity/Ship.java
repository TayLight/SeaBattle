package com.seabattle.SeaBattle.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Ship {
    // 0 и 1 если горизонтально
    // 1 и 0 если вертикально
    private int x;
    private int y;
    private int kx;
    private int ky;
    private int decks;

    public Ship(int x, int y, int kx, int ky, int decks) {
        this.x = x;
        this.y = y;
        this.kx = kx;
        this.ky = ky;
        this.decks = decks;
    }
}
