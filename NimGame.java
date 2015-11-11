
package nimgame;

import javax.swing.JOptionPane;

/*
 * A test class for the Nim game.
 */
/**
 *
 * @author Paola Jiron
 */
public class NimGame
{
    public static void main(String[] args)
    {
        // an array holding all player objects
        
        Player[] gamers = { new Human(), new Dumb(), new Smart()};
        
        // ask user if he/she would like to play
        
        int choice = JOptionPane.showConfirmDialog(null, "WELCOME to NIM\nWould"
             + " you like to play?", " PLAYER MODE ", JOptionPane.YES_NO_OPTION,
             JOptionPane.QUESTION_MESSAGE);
        
        while ( choice == 0 )
        {
            // an array to implement the level of difficulty for the JOP
            
            Object[] option = {"EASY", "EXPERT"};
            
            // ask the user if he/she wants to play in easy mode or expert mode
            
            int in = JOptionPane.showOptionDialog(null, "Choose your level of"
                 + " difficulty.", " DIFFICULTY", JOptionPane.YES_NO_CANCEL_OPTION,
                 JOptionPane.QUESTION_MESSAGE, null, option, option[1]);
            
            Player player1 = gamers[0]; // the user
            Player player2 = null;      // the opponent
            
            // if in difficult mode
            
            if ( in == 0 )
            {
                player2 = gamers[1];        // play against the smart computer
            }
            
            // if in easy mode
            
            if ( in == 1 )
            {
                player2 = gamers[2];        // play against the dumb computer
            }
            
            Nim playGame = new Nim(player1 , player2); // initialize the game
            
            playGame.play();    // initiate the game
            
            // at the end of the game, ask the user if he/ she would like to
            // play again
            
            choice = JOptionPane.showConfirmDialog(null, "Would you like to play"
                 + " again?", " PLAYER MODE ", JOptionPane.YES_NO_OPTION,
             JOptionPane.QUESTION_MESSAGE);
        }
        
        // exit the game
        JOptionPane.showMessageDialog(null, "GOODBYE!");
    }
    
}   // end of NimGame class
