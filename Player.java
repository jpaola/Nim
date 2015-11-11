/*
 * An interface to represent attributes of all players in the Nim game.
 */
/**
 *
 * @author Paola Jiron
 */
package nimgame;

public interface Player
{
    String getName();       // returns the name of the player
    
    void setName(String name);       // sets the player's name
/**
 * Manages a player's move on the game.
 * @param pileSize The amount of marbles.
 * @return The marbles remaining after each move.
 */
 int move( int pileSize);   



}   // end of Player interface