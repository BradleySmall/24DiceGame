package com.small.dicegame;

import java.util.Random;

public class Die {
    private int numSides;
    private int value;
    public static final Random rnd = new Random();

    public Die() {
        this(6, 6);
    }
    public Die(int sides) {
        this(sides, sides);
    }
    public Die(int sides, int initValue) {
        numSides = sides;
        value = initValue;
    }


    public void roll() {
        value = rnd.nextInt(numSides) + 1;
    }

    public int getValue() {
        return value;
    }
}