package nimgame;

/**
 * Generates and manages the pile of marbles for the Nim game.
 */
/**
 *
 * @author Paola Jiron
 */
import java.util.Random;

public final class Pile
{
    private int pileSize;       // the amount of marbles
    
    /**
     * A constructor for the pile of marbles.
     */
    public Pile()
    { 
        // generate a pile between 10 && 100
        
        Random generate = new Random();
        
        pileSize = generate.nextInt(91) + 10;
    }
    /**
     * Sets the pile size after each move.
     * @param marbles The amount of marbles to remove from the pile.
     */
    public void setPileSize( int marbles)
    {
        pileSize -= marbles ;
    }
    /**
     * Returns the pile size.
     * @return The pile size.
     */
    public int getPile()
    {
        return pileSize;
    }
    
}   // end of Pile class
