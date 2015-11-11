package yulongproductions.com.skatedice;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Yulong on 7/11/2015.
 *
 * This class represents Dice that deal with Skateboarding.
 * This class was intended to help me learn some more tricks,
 * and it revolves around a dice that generates the stance
 * (regular, switch, nollie, fakie), direction (frontside, backside),
 * degrees (180, 360, 540), and then the trick itself.
 */
public class TrickManager {
    //Fields
    private List<String> tricks;

    // Class constants
    public static final int STANCES = 4;
    public static final int DIRECTIONS = 2;
    public static final int ROTATIONS = 3;
    public static final boolean EASY = true;

    // Constructs a list of tricks from an external file
    public TrickManager() {
        this.tricks = new ArrayList<>();
        String[] trickList = {
                "ollie", "kickflip", "shuvit", "heelflip", "bigspin", "revert"
        };
        this.transfer(trickList, this.tricks);
    }

    // Returns the String representation of the stance
    public String getStance() {
        Dice stance = new Dice(STANCES);
        int number = stance.getNumber();
        if (number == 0) {
            return "regular ";
        } else if (number == 1) {
            return "switch ";
        } else if (number == 2) {
            return "nollie ";
        } else {
            return "fakie ";
        }
    }

    // Returns the String representation of the direction
    public String getDirection() {
        Dice direction = new Dice(DIRECTIONS);
        int number = direction.getNumber();
        if (number == 0) {
            return "frontside ";
        } else {
            return "backside ";
        }
    }

    // Returns the number of degrees of the rotation
    public String getDegrees() {
        Dice degrees = new Dice(ROTATIONS);
        int number = degrees.getNumber();
        if (number == 0) {
            return "";
        } else if (number == 1) {
            return "180";
        } else {
            return "360";
        }
    }

    // Returns the String representation of the trick name
    public String getTrick() {
        Dice trick = new Dice(this.tricks.size());
        return this.tricks.get(trick.getNumber());
    }

    // Returns the String representation of the full trick to do
    public String printTrick() {
        String trick = this.getTrick();
        if (EASY) {
            return this.getStance() + this.getDirection()
                    + this.getDegrees() + " " + trick;
        } else { // not easy
            return this.getStance() + this.getDirection()
                    + this.getDegrees() + " " + trick + " " + this.ender(trick);
        }
    }

    // Private method that tranfers all the elements of an array to an ArrayList of
    // the same type
    private void transfer(String[] list, List<String> newList) {
        for (String item : list) {
            newList.add(item);
        }
    }

    private String ender(String trick) {
        String[] flipTricks = {"heelflip", "kickflip"};
        Dice flipDice = new Dice(flipTricks.length);
        if (trick.equals("heelflip") || trick.equals("kickflip")) {
            return "shuvit";
        } else if (trick.equals("shuvit")) {
            // return either heelflip or kickflip
            return flipTricks[flipDice.getNumber()];
        } else {
            return "";
        }
    }
}
