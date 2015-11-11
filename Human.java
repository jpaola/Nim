/*
 * A class to represent the human player.
 */
/**
 *
 * @author Paola Jiron
 */
package nimgame;

import javax.swing.JOptionPane;

public class Human implements Player
{
    // instance var's
    private String name;    // the player's name
    
    /**
     * A constructor for the human.
     */
    public Human(){}
    
    /**
     * Sets the name of the human.
     * @param userName The player's name.
     */
    public void setName( String userName )
    {
        name = userName;
    }
    /**
     * Returns the name of the human.
     * @return The name of the player.
     */
    public String getName()
    {
        return name;
    }
    /**
     * Handles the player's input.
     * @param input The value the human enters.
     * @param pileSize The amount of marbles in the pile.
     * @return True if the move is legal, False otherwise.
     */
    private Boolean checkChoice(String input, int pileSize)
    {
     int userInput;     // local var
        try
        {
            userInput = Integer.parseInt(input);      // check for correct input
            
            return ((userInput >= 1) && (userInput <= (pileSize/2)));
        }
        catch ( NumberFormatException nfe ) //otherwise throw exception
        {
            JOptionPane.showMessageDialog(null, "\nInput must be"
                      + " a number. Try Again.");
                 
            return false;
        }
        
    }
    /**
     * Removes a number of marbles from a pile. Permitted moves are between 1
     * and half the pile size. If the pile size is odd then 1 less than the size
     * is permitted.
     * @param pileSize The total amount of marbles in the pile.
     * @return The amount of marbles the player chooses to move.
     */
    public int move(int pileSize)
    {
        
        //local var's
        
        int marbles = -1;
        int newPile = 0;
        
        // for every move..
        
        while ( marbles < 0)
        {
            // if no marbles, exit
            
            if ( Math.abs(pileSize) == 0)
            {
                System.exit(0);
            }
            
            // ask the player what value to remove from the pile
            
            String choice = JOptionPane.showInputDialog("There are " 
                            + Math.abs(pileSize) + " marbles.\n"
                 + "You can remove at least 1 and at most "
            + Math.abs(pileSize/2) + "\nYour turn to move.");
            
             // if no input, exit game
            
            if ( choice == null )  
            {
                JOptionPane.showMessageDialog(null, "GOODBYE!");
                System.exit(0);
            }
            
            // if choice is legal
            
            if ( checkChoice(choice, pileSize))
            {
                marbles = Integer.parseInt(choice);
                
                System.out.println("Your move: " + marbles);    // echo choice
                
                newPile = pileSize - marbles;       // adjust pile
                
                // echo the new pile
                
                System.out.println("Marbles left: " + Math.abs(newPile));
            }
        }
        return marbles;     // human's move
    }
    
}   // end of Human class
