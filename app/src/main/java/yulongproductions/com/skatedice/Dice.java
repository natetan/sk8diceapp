package yulongproductions.com.skatedice;

import java.util.Random;

/**
 * Created by Yulong on 7/11/2015.
 */

/*
    This class creates dice of any non-negative numbers and
    can be used universally for many different applications
    other than skateboarding.
 */
public class Dice {
    private Random r;
    private int sides;

    // Constructs a dice with x sides
    public Dice(int sides) {
        this.sides = sides;
        this.r = new Random();

    }

    // Returns a random side of the dice
    public int getNumber() {
        return this.r.nextInt(this.sides);
    }
}
