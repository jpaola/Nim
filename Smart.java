/*
 * A class to represent the smart computer player.
 */
/**
 *
 * @author Paola Jiron
 */
package nimgame;
import java.util.Random;

public class Smart implements Player
{
    // instance var's
    private String name = "Spock";
    
    Random generate;
    
    /**
     * A constructor  for the smart computer.
     */
    public Smart(){}
    
    /**
     * Returns the pre-set name for the smart computer.
     * @return The name of the smart computer.
     */
    public String getName()
    {
        return name;
    }
    /**
     * Manages the smart computer's move by generating a number between 1 and
     * enough marbles to make the remaining pile a power of two minus one
     * ( 1, 3, 7, 15, 31, or 63). The smart computer cannot be beaten if it has
     * the first move, unless the initial pile size happens to be 15, 31, or 63.
     * @param pileSize The amount of marbles in the pile.
     * @return The amount of marbles the player chooses to move.
     */
    public int move(int pileSize)
    {
       // local var's
        
       int num = -1 ,newPile, result = 0;
       
       // if the pile is a value == (2^n) - 1
       
       if (pileSize == 15 || pileSize == 31 || pileSize == 63)
       {
       
       // generate and compute a legal value from the pile...like the dumb comp
        
       num = 1 + (int) (Math.random() * ( pileSize / 2 )); 
       
       System.out.println(getName() + " removes: " + num); // echo the move
        
       newPile = pileSize - num;
       
       // display results
        
       System.out.println("Marbles left : " + Math.abs(newPile)); 

       return num ;    // return Spock's move
       
       }
       else     // otherwise, play smart
       {
           for ( int m = 0 ; m <= (pileSize / 2) ; m++ )
           {
             // does subtracting m ....
            
             result = pileSize - m ;   
                  
            for ( int n = 0 ; n < 7 ; n++ )     
            {
                if ( result == (Math.pow(2, n) - 1))    //....yield (2^n) - 1?
                {
                    // if the pileSize at m == 0 is a power of 2 minus 1
                    // generate a legal number from half the pile and return
                    
                    if (m == 0) 
                    {
                        // echo the move 
                    
                        System.out.println(getName() + " removes: " 
                             + pileSize/2); 
                        
                        // display results
                    
                        System.out.println("Marbles left : " 
                             + Math.abs(pileSize - (pileSize/2))); 
                        
                        return pileSize/2;  // spock's move
                    }
                    
                    // echo the move 
                    
                    System.out.println(getName() + " removes: " + m); 
                    
                    // display results
                    
                    System.out.println("Marbles left : " + Math.abs(result)); 
                    
                    return m;      // return Spock's move
                }
            }
           }  
           
       }
       return Math.abs(num);
    }

    @Override
    public void setName(String name)
    {   
      // intentionally left blank.. i.e. pre-set name 
    }
}  // end of Smart class
