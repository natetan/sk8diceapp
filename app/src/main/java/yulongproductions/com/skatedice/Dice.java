package yulongproductions.com.skatedice;

import java.util.Random;

/**
 * Created by Yulong on 7/11/2015.
 */
public class Dice {
    private Random r;
    private int sides;

    public Dice(int sides) {
        this.sides = sides;
        this.r = new Random();

    }

    public int getNumber() {
        return this.r.nextInt(this.sides);
    }
}
