/*
 * A class to represent the dumb computer player.
 */
/**
 *
 * @author Paola Jiron
 */
package nimgame;

import java.util.Random;

public class Dumb implements Player
{
    // instance var's
    Random generate;
    private final String name = "Homer";
    
    /**
     * A constructor for the dumb computer.
     */
    public Dumb(){}
    
    /**
     * Returns the pre-set name of the dumb computer.
     * @return The name of the dumb computer.
     */
    public String getName()
    {
        return name;
    }
    /**
     * Manages the dumb computer's move by generating a number between 1 and
     * half the pile size and returns the amount the player chooses to move.
     * @param pileSize The amount of marbles in the pile.
     * @return The amount of marbles the player chooses to move.
     */
    public int move(int pileSize)
    {
        // local var's
        
        int num = -1 ,newPile;
        
        // generate and compute a legal value from the pile
        
        num = 1 + (int) (Math.random() * (pileSize/2)); 
        
        System.out.println(getName() + " removes: " + num); // echo the move
        
        newPile = pileSize - num;
        
        // display results
        
        System.out.println("Marbles left : " + Math.abs(newPile)); 

        return num ;    // return Homer's move
    }

    @Override
    public void setName(String name)
    {
     // intentionally left blank.. i.e. pre-set name
    }

}   // end of Dumb class
