import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Test the while loop in getPointsProper() from postlab of Plotter class.
 *
 * @author Joel Swanson
 * @version 02.16.2014
 */
public class TestPart5
{
    private int numberOfSquares = 0;
    private int offscreenSquares = 0;
    private int blackCount = 0;
    private int redCount = 0;
    private int yellowCount = 0;
    private int blueCount = 0;
    private int whiteCount = 0;
    private int otherCount = 0;    

        
    /**
     * Make sure exit has been updated to new bounds.
     */
    @Test
    public void testPlotPointsProperExit()
    {        
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();                
        checkPlotPointsProperExit();   
        
    }        


    /**
     * Run various tests plotting points.
     */
    @Test
    public void testOnePoint1()
    {
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();                
        checkOnePoint(0, 0);
    }
    /**
     * Run various tests plotting points.
     */
    @Test
    public void testOnePoint2()
    {
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();                
        checkOnePoint(20, 20);
    }
    /**
     * Run various tests plotting points.
     */
    @Test
    public void testOnePoint3()
    {
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();                
        checkOnePoint(0, 20);
    }
    /**
     * Run various tests plotting points.
     */
    @Test
    public void testOnePoint4()
    {
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();                
        checkOnePoint(20, 20);
    }
    /**
     * Run various tests plotting points.
     */
    @Test
    public void testManyPoints()
    {
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();                
        checkMultiplePoints();
    }
    
    /**
     * Check for a given number of points on the canvas.
     * @param expected There should be only this many points
     * on the canvas.
     */
    private void checkNumberOfPoints(int expected)
    {
        String fb = "";
        int found = Canvas.getCanvas().getCircles().size();
        
        if (found > expected)
        {
            fb += "Failure in TestPostlab while checking plotPointsProper().\n";
            fb += "This test has plotted " + expected + " point(s).\n";
            fb += "Your graph has " + found + "point(s).\n";
            fb += "Make sure you are only plotting points as taken from\n";
            fb += "the keyboard in plotPoints().\n";
            fail(fb);            
        }
        
        if (found  < expected)
        {
            fb += "Failure in TestPostlab while checking plotPointsProper().\n";
            fb += "This test has plotted " + expected + " point(s).\n";
            fb += "Your graph has " + found + "point(s).";
            fb += "Make sure you are plotting ALL points that are not out\n";
            fb += "of bounds.\n";
            fail(fb);            
        }
    }
    
    /**
     * Check all possible reasons the while loop should
     * exit in plotPointsProper().
     */
    public void checkPlotPointsProperExit()
    {
        checkPlotPointsExit(-160, 100);        
        checkPlotPointsExit(160, 100);        
        checkPlotPointsExit(100, -160);        
        checkPlotPointsExit(100, 160);           
    }
    
    /**
     * Make sure plotPointsProper() exits on an out of bounds value.
     * 
     * @param x X coordintate for a point to test out of bounds
     * conditions on the while loop in plotPoints().
     * 
     * @param y Y coordintate for a point to test out of bounds
     * conditions on the while loop in plotPoints().
     */
    public void checkPlotPointsExit(int x, int y)
    {
        String fb = "";
        Plotter plotter = new Plotter();
        Scanner input = new Scanner(x + "\n" + y + "\n");
        try 
        {
            plotter.plotPointsProper(input);
        }
        catch (NoSuchElementException e)
        {
            fb += "Failure in TestPostlab while checking plotPointsProper().\n";
            fb += "Your while loop doesn't exit correctly using point ";
            fb += "(" + x + ", " + y + ").";
            fail(fb);
        }                       
    }
    
    /**
     * Make sure multiple points are plotted and the
     * loop exits.
     * 
     * @param x X coordinate of a point to plot.
     * @param y Y coordinate of a point to plot.
     */
    public void checkOnePoint(int x, int y)
    {
        String fb = "";
        Plotter plotter = new Plotter();
        Scanner input = new Scanner(x + "\n" + y + "\n-160\n-160\n");

        plotter.plotPointsProper(input);
        ArrayList<Circle> circles = Canvas.getCanvas().getCircles();

        if (circles.size() == 0)
        {
            fb += "Failure in TestPostlab while testing plotPointsProper()\n";
            fb += "When plotting point (" + x + ", " + y 
                + "), plotPointsProper() failed to create ANY circles.\n";
            fail(fb);
        }        
        
        if (canFindPoint(x, y, circles))
        {
            fb += "Failure in TestPostlab while testing plotPointsProper()\n";
            fb += "Plotted (" + x + ", " + y + ") in plotPointsProper().\n";
            fb += "Found a point at that location.  Therefore, you did no\n";
            fb += "translation.  This method is essentially the same as\n";
            fb += "plotPoints() from activity 4.\n";
            fail(fb);
        }        

        if (y != 0 && canFindPoint(x + 144, y + 144, circles))
        {
            fb += "Failure in TestPostlab while testing plotPointsProper()\n";
            fb += "Plotted (" + x + ", " + y + ") in plotPointsProper().\n";
            fb += "Found the point at (" + x + ", " + -y + ").\n";
            fb += "You did not correct the problem of having the y axis ";
            fb += "reversed.\n";
            fail(fb);
        }        

        if (!canFindPoint(x + 144, -y + 144, circles))
        {
            fb += "Failure in TestPostlab while testing plotPointsProper()\n";
            fb += "Plotted (" + x + ", " + y + ") in plotPointsProper().\n";
            fb += "Found a point plotted elsewhere. Your process for \n";
            fb += "translating the point is not correct.\n";
            fail(fb);
        }                
    }
    
    /**
     * Make sure multiple points are plotted and the
     * loop exits.
     */
    public void checkMultiplePoints()
    {
        String fb = "";
        Canvas.getCanvas().resetCanvas();        
        Plotter plotter = new Plotter();
        String inputString = "";
        inputString += "50\n0\n0\n50\n0\n-50\n-50\n0\n-50\n-50\n";
        inputString += "-50\n50\n50\n-50\n50\n50\n0\n0\n";
        inputString += "-160\n-160\n";
        Scanner input = new Scanner(inputString);
        plotter.plotPointsProper(input);
        checkNumberOfPoints(9);
        
        ArrayList<Circle> circles = Canvas.getCanvas().getCircles();

        if (!canFindPoint(194, 144, circles) 
            || !canFindPoint(144, 194, circles)
            || !canFindPoint(94, 144, circles)
            || !canFindPoint(144, 94, circles)
            || !canFindPoint(94, 94, circles) 
            || !canFindPoint(194, 94, circles)
            || !canFindPoint(94, 194, circles)
            || !canFindPoint(194, 194, circles)
            || !canFindPoint(144, 144, circles) 
            )
        {
            fb += "Failure in TestPostlab while checking plotPointsProper().\n";
            fb += "Printed nine points.  One or more did not show\n";
            fb += "up on your graph at the correct position.\n";
            fail(fb);
        }
        
    }
           
    /**
     * Search the given circle array for a circle with the given x and y
     * coordinates.  These are NOT translated.  Checks for the circle
     * having xPosition and yPosition as the canvas sees them.
     * @param x Search for a circle with this x.
     * @param y Search for a circle with this y.
     * @param circles ArrayList of Circle ojbects to check.
     * 
     * @return Returns true if a circle is found with the given x,y coordinate.
     */
    public boolean canFindPoint(int x, int y, ArrayList<Circle> circles)
    {
        for (Circle circle : circles)
        {
            if (circle.getxPosition() == x && circle.getyPosition() == y)
            {
                return true;
            }
        }
        return false;        
    }
    
}
