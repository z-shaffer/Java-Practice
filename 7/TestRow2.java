 

import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout;        
import java.util.ArrayList;

/**
 * Tests the changes needed to the row class for Activity 3.
 *
 * @author  Julia Dana
 * @version 2014-04-09
 */
public class TestRow2
{
    
    @Rule
    public Timeout globalTimeout = new Timeout(10000);
    
    /**
     * Tests that the moveVertically method moves a row by the given amount.
     */
    @Test
    public void testMoveVertically()
    {
        Canvas c = Canvas.getCanvas();
        c.clear();        
        Row r = new Row();
        int amountToMove = 37;
        r.moveVertically(amountToMove);
        
        ArrayList<Square> squares = r.getSqList();
        
        for (Square s : squares)
        {
            if (s.getY() != amountToMove)
            {
                fail("Did not move the row by the given amount.");
            }
        }
        
        // Move the row again since it is now at a non-zero location.
        r.moveVertically(amountToMove);
        
        squares = r.getSqList();
        
        for (Square s : squares)
        {
            if (s.getY() != amountToMove + amountToMove)
            {
                if (s.getY() == amountToMove)
                {
                    fail("Moved the row to given y,"
                        + " rather than changing it by the given y");
                }
                
                fail("Did not move the row by the given amount.");
            }
        }
        
    }
}
