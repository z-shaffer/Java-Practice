/**
 * TestPrelab2.java
 */
import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Describe TestPrelab2 here.
 *
 * @author Joel Swanson
 * @version 02.13.2014
 */
public class TestPart1B
{
    private TestPart1A tp1;
    private int grade;
    private int circleStyleErrors;
    private int squareStyleErrors;
    private int plotterStyleErrors;    
    
    /**
     * Default constructor for test class CheckPrelab2.
     */
    public TestPart1B()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    
    /**
     * Checks the functionality of the Circle constructor
     * with two different sets of data.
     */
    @Test
    public void testCircle()
    {
        testCircleConstructor(5, 6);
        testCircleConstructor(11, 20);
    }

    /**
     * Checks the functionality of the Square constructor
     * with two different sets of data.
     */
    @Test
    public void testSquare()
    {
        testSquareConstructor(10, 20);
        testSquareConstructor(30, 40);
    }
    
    /**
     * Test Square position constructor.
     * 
     * @param x The xPosition to test this Square.
     * @param y The yPosition to test this Square.
     */
    public void testSquareConstructor(int x, int y)
    {
        String fb = "";
        Square square = new Square(x, y);
        if (square.getxPosition() != x)
        {
            fb += "Fail in TestPrelab2.\n";
            fb += "Square parameter constructor improperly set xPosition.\n";
            fb += "Square square = new Square(" + x + "," + y + ");\n";
            fb += "did not set xPosition to " + x + ".\n";
            fail(fb);
        }
        
        if (square.getyPosition() != y)
        {
            fb += "Fail in TestPrelab2.\n";
            fb += "Square parameter constructor improperly set xPosition.\n";
            fb += "Square square = new Square(" + x + "," + y + ");\n";
            fb += "did not set yPosition to " + y + ".\n";
            fail(fb);
        }
        
        if (!square.getColor().equals("black"))
        {
            fb += "Fail in TestPrelab2.\n";
            fb += "Square parameter constructor improperly set Color.\n";
            fb += "Check lab documentation for proper color.\n";
            fail(fb);            
        }
        
        if (square.getSize() != 5)
        {
            fb += "Fail in TestPrelab2.\n";
            fb += "Square parameter constructor improperly set size.\n";
            fb += "Check lab documentation for proper size.\n";
            fail(fb);            
        }
        
        if (!square.isIsVisible() || !square.isMvr())
        {
            fb += "Fail in TestPrelab2.\n";
            fb += "Square parameter constructor did not make the square " 
                + "visible correctly.\n";
            fb += "Constructor should run makeVisible().\n";
            fb += "Check lab documentation.\n";
            fail(fb);             
        }
    }

    /**
     * Test Circle position constructor.
     * 
     * @param x The xPosition to test this Circle.
     * @param y The yPosition to test this Circle.
     */
    public void testCircleConstructor(int x, int y)
    {
        String fb = "";
        Circle circle = new Circle(x, y);
        if (circle.getxPosition() != x)
        {
            fb += "Fail in TestPrelab2.\n";
            fb += "Circle parameter constructor improperly set xPosition.\n";
            fb += "Circle circle = new Circle(" + x + "," + y + ");\n";
            fb += "did not set xPosition to " + x + ".\n";
            fail(fb);
        }
        
        if (circle.getyPosition() != y)
        {
            fb += "Fail in TestPrelab2.\n";
            fb += "Circle parameter constructor improperly set xPosition.\n";
            fb += "Circle circle = new Circle(" + x + "," + y + ");\n";
            fb += "did not set yPosition to " + y + ".\n";
            fail(fb);
        }
        
        if (!circle.getColor().equals("red"))
        {
            fb += "Fail in TestPrelab2.\n";
            fb += "Circle parameter constructor improperly set Color.\n";
            fb += "Check lab documentation for proper color.\n";
            fail(fb);            
        }
        
        if (circle.getDiameter() != 10)
        {
            fb += "Fail in TestPrelab2.\n";
            fb += "Circle parameter constructor improperly set diameter.\n";
            fb += "Check lab documentation for proper diameter.\n";
            fail(fb);            
        }
        
        if (!circle.isIsVisible() || !circle.isMvr())
        {
            fb += "Fail in TestPrelab2.\n";
            fb += "Circle parameter constructor did not make the circle " 
                + "visible correctly.\n";
            fb += "Constructor should run makeVisible().\n";
            fb += "Check lab documentation.\n";
            fail(fb);             
        }
    }
}
