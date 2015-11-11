/*
 * A class to conduct the Nim game using methods from the Pile class 
 * and Player interface.
 */
/**
 *
 * @author Paola Jiron
 */
package nimgame;

import javax.swing.JOptionPane;

public class Nim
{
    // instance var's
    private final Player player1, player2;          // the players
    private final Pile pile;                        // the pile of marbles
    
    /**
     * A constructor for Nim with two players.
     * @param playerA Player one.
     * @param playerB Player two.
     */
    public Nim(Player playerA, Player playerB)
    {
        // initialize players && pile of marbles
        
        this.player1 = playerA;     
        this.player2 = playerB;
        
        pile = new Pile();
    }
    /**
     * Conducts the game.
     */
    public void play()
    {
        // local var's
        
        int marbles = pile.getPile();
        
        // get human's name
        
        String name = JOptionPane.showInputDialog("What is your name?");
        
        // repeat until human enter's a name
        
        while (name.isEmpty())
        {
          JOptionPane.showMessageDialog(null,"You must enter a name to continue.");
          
          name  = JOptionPane.showInputDialog("What is your name?");
        }
        
        player1.setName(name);      // set human's name
        
        // echo print the names of both players
        
        System.out.println("\n" + player1.getName().toUpperCase() + " vs. " 
                            + player2.getName().toUpperCase());
        
        // initial pile
        
        System.out.println("\nInitial pile: " + marbles);
        
        // ask human if he/ she would like to go first
        
        int order = JOptionPane.showConfirmDialog(null, "Do you want "
             + "to go first?", "SEQUENCE", JOptionPane.YES_NO_OPTION,
             JOptionPane.QUESTION_MESSAGE);
        
        while (marbles > 0)     // while pile is not empty
            
        {
            if ( order == 0)    // human decides to go first
            {
                humanFirst(marbles);
            }
            else    // otherwise.. computer goes first
            {
                computerFirst(marbles);
            }
            
            marbles = pile.getPile();       // get pile after each move
            
            if ( marbles == 1)      // check if game over
            {
                break;
            }
        }
        
    }
    /**
     * Processes the game if human decides to go first.
     * @param marbles The pile of marbles.
     */
    private void humanFirst(int marbles)
    {
        int newPile = player1.move(marbles);    // human's move
        
        pile.setPileSize(newPile);              // recalculate pile
        
        // if there is a winner, announce
        
        if ( pile.getPile() == 1 )    
        {
            System.out.println("\nGAME OVER " + player2.getName().toUpperCase()
                                + " LOSES!\n" + player1.getName().toUpperCase()
                                + " WINS!");
            return;
        }
        
        newPile = player2.move(pile.getPile());     // computer's move
        
        pile.setPileSize(newPile);          // recalculate pile of marbles
        
        // if there is a winner, announce
        
        if ( pile.getPile() == 1 )    
        {
            System.out.println("\nGAME OVER " + player1.getName().toUpperCase()
                                + " LOSES!\n" + player2.getName().toUpperCase()
                                + " WINS!");
            
        }
        
    }
    /**
     * Processes the game if the computer goes first.
     * @param marbles The pile of marbles.
     */
    private void computerFirst(int marbles)
    {
        int newPile = player2.move(marbles);    // computer's move
        
        pile.setPileSize(newPile);              // recalculate pile
        
          // if there is a winner, announce it
        
        if ( pile.getPile() == 1 )    
        {
            System.out.println("\nGAME OVER " + player1.getName().toUpperCase()
                                + " LOSES!\n" + player2.getName().toUpperCase()
                                + " WINS!");
            return;
        }
        newPile = player1.move(pile.getPile());     // human's move
        
        pile.setPileSize(newPile);              // recalculate pile of marbles
        
         // if there is a winner, announce it
        
        if ( pile.getPile() == 1 )   
        {
            System.out.println("\nGAME OVER " + player2.getName().toUpperCase()
                                + " LOSES!\n" + player1.getName().toUpperCase()
                                + " WINS!");
           
        }
    }
}   // end of Nim class
