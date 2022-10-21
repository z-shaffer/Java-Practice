 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;    
import java.util.ArrayList;

/**
 * The test class TestCheckerBoard.
 *
 * @author  Julia Dana
 * @version 2014-04-09
 */
public class TestCheckerBoard
{

    @Rule
    public Timeout globalTimeout = new Timeout(10000);    
    
    
    /**
     * Performs a high-level check of the no-arg constructor for a CheckerBoard.
     */
    @Test
    public void testNoArgConstructor()
    {
        Canvas c = Canvas.getCanvas();
        c.clear();
        long initTime = System.currentTimeMillis();
        
        CheckerBoard cb = new CheckerBoard();
        
        long afterTime = System.currentTimeMillis();
        
        assertEquals("You don't have the correct number of red squares\n", 
            32, c.countSquaresByColor("red"));
            
        assertEquals("You don't have the correct number of black squares\n", 
            32, c.countSquaresByColor("black"));
            
        // Check alternating and size.
        for (int j = 0; j < 8; j++)
        {
            Row r = cb.getRowList().get(j);
            ArrayList<Square> squares = r.getSqList();
            for (int i = 0; i < 8; i++)
            {
                Square s = squares.get(i);
                if ((i + j) % 2 == 0)
                {
                    // Expects the rows to be in the arraylist in order.
                    assertTrue("Does not alternate colors correctly.",
                        s.getColor().equals("black"));
                }
                else
                {
                    // Expects the rows to be in the arraylist in order.
                    assertTrue("Does not alternate colors correctly.",
                        s.getColor().equals("red"));
                }
                
                assertEquals("Squares were not the expected size.", 
                    48, s.getSize());
            }
        }
        
        assertEquals("You don't have the correct number of Squares in this row,"
            + " or the row is misplaced.",
            8, c.countSquaresAtY(0));
            
            
        for (int i = 0; i < 8; i++)
        {
            int expectedInColumn = 8;

            assertEquals("You don't have the correct number"
                + " of squares in column " + (i + 1),
                expectedInColumn, c.countSquaresAtX((50 * i)));
        }
    }
}
