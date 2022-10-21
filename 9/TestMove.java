/**
 * TestTire2.java
 */
import static org.junit.Assert.fail;
import org.junit.Test;
import org.junit.Rule;
import org.junit.rules.Timeout; 
import java.util.Random;
import org.junit.Before;   

/**
 * Describe TestTire2 here.
 *
 * @author Joel Swanson modified Brooke Tibbett
 * @version 03.08.2014 modified 10.30.20
 */
public class TestMove
{
    private Random random;

    @Rule
    public Timeout timeout = new Timeout(30000);    

    public TestMove()
    {
        random = new Random();
    }

        /**
     * Test the copy method.
     */
    @Test
    public void checkEquals()
    {
        int cardinal = random.nextInt(MoveType.values().length);
        Move m1 = new Move(MoveType.values()[cardinal], random.nextInt(10));
        Move m2 = new Move(m1.getMoveType(), m1.getRange() + 1);
        Move m3 = new Move(MoveType.values()[(cardinal + 1) % MoveType.values().length], m1.getRange());
        Move m4 = new Move(m1.getMoveType(), m1.getRange());
        String fb;
        if(m1.equals(m2) || m1.equals(m3))
        {
            fb = "Fail in TestMove.\n";
            fb += "The equals method returned true when";
            fb += " the objects were different.\n";
            fail(fb); 
        }
        
        if(!m1.equals(m4))
        {
            fb = "Fail in TestMove.\n";
            fb += "The equals method returned false when";
            fb += " the objects were the same.\n";
            fail(fb); 
        }
    }
    
    /**
     * Test the copy method.
     */
    @Test
    public void checkCopy()
    {
        Move move;    
        int randR = random.nextInt(10);
        int randT = random.nextInt(4) + 1;

        switch(randT)
        {
            case 1:
                move = new Move(MoveType.BASICATTACK, randR);
                break;
            case 2:
                move = new Move(MoveType.RANGEDATTACK, randR);
                break;
            case 3:
                move = new Move(MoveType.DEFEND, randR);
                break;
            case 4:
                move = new Move(MoveType.MOVE, randR);
                break;
            default:
                move = new Move();
                break;
        }            
        checkCopy(move);

        randR = random.nextInt(10);
        randT = random.nextInt(4) + 1;

        switch(randT)
        {
            case 1:
                move = new Move(MoveType.BASICATTACK, randR);
                break;
            case 2:
                move = new Move(MoveType.RANGEDATTACK, randR);
                break;
            case 3:
                move = new Move(MoveType.DEFEND, randR);
                break;
            case 4:
                move = new Move(MoveType.MOVE, randR);
                break;
            default:
                move = new Move();
                break;
        }    

        checkCopy(move);
    }

    /**
     * Check the toString method.
     */
    @Test
    public void checkToString()
    {
        Move move;    
        int randR = random.nextInt(10);
        int randT = random.nextInt(4) + 1;
        String str = "";

        switch(randT)
        {
            case 1:
                move = new Move(MoveType.BASICATTACK, randR);
                str = MoveType.BASICATTACK + " for " + randR;
                break;
            case 2:
                move = new Move(MoveType.RANGEDATTACK, randR);
                str = MoveType.RANGEDATTACK + " for " + randR;
                break;
            case 3:
                move = new Move(MoveType.DEFEND, randR);
                str = MoveType.DEFEND + " for " + randR;
                break;
            case 4:
                move = new Move(MoveType.MOVE, randR);
                str = MoveType.MOVE + " for " + randR;
                break;
            default:
                move = new Move();
            break;
        } 

        checkToString(move, str);
    }

    
    /**
     * Test the copy method with data.
     * @param original The original tire to make a copy of.
     */
    public void checkCopy(Move original)
    {
        String fb = "";
        Move copy = original.copy();

        if (copy == null)
        {
            fb += "Fail in TestMove.\n";
            fb += "The copy method returned a null value.\n";
            fail(fb);                 
        }
        else if (original == copy)
        {
            fb += "Fail in TestMove.\n";
            fb += "The copy method returned the actual move object\n" 
            + "instead of making and returning a copy of the object.\n";
            fail(fb);                                 
        }
        else if (original.getRange() != copy.getRange())
        {
            fb += "Fail in TestMove.\n";
            fb += "The copy method returned a Move object with a\n";
            fb += "range that is different than the original\n";
            fb += "move object.\n";
            fail(fb);                                 
        }
        else if (original.getMoveType() != copy.getMoveType())
        {
            fb += "Fail in TestMove.\n";
            fb += "The copy method returned a Move object with a\n";
            fb += "MoveType that is different than the original\n";
            fb += "Move object.\n";
            fail(fb);                                 
        }
    }

    /**
     * Test toString with given parameters.
     * @param tire The tire to test with.
     * @param answer The correct answer for comparison.
     */
    public void checkToString(Move move, String answer)
    {
        String fb = "";

        String data = move.toString();

        if (data == null)
        {
            fb += "Fail in TestMove.\n";
            fb += "The toString method returned a null value.\n";
            fail(fb);                 
        }
        else if (data.contains("\n"))
        {
            fb += "Fail in TestMove.\n";
            fb += "The toString method returned incorrect data.\n";
            fb += "The value from toString should not contain " 
            + "newline characters.\n";
            fail(fb);                                                 
        }            
        else if (!data.equals(answer))
        {
            fb += "Fail in TestMove.\n";
            fb += "The toString method returned incorrect data.\n";
            fb += "Expected:   " + answer + "\n";
            fb += "Your value: " + data + "\n";
            fail(fb);                                 
        }        
    }
}
