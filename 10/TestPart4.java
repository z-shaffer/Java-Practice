import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Test the while loop in getPoints() from activity 3 of Plotter class.
 *
 * @author Joel Swanson
 * @version 02.16.2014
 */
public class TestPart4
{
    private TestPart1A tp1;
    private TestPart1B tp2;
    private TestPart2 ta1;
    private TestPart3 ta2;
    
    private int numberOfSquares = 0;
    private int offscreenSquares = 0;
    private int blackCount = 0;
    private int redCount = 0;
    private int yellowCount = 0;
    private int blueCount = 0;
    private int whiteCount = 0;
    private int otherCount = 0;    

    /**
     * Test plotting of one point.
     */
    @Test
    public void testOnePoint()
    {        
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();        
        
        checkOnePoint(20, 200);
        checkNumberOfPoints(1);
        
    }    
    
    /**
     * Test plotting of two points.
     */
    @Test
    public void testTwoPoints()
    {        
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();        
        
        checkOnePoint(20, 200);
        checkNumberOfPoints(1);
        checkOnePoint(200, 30);
        checkNumberOfPoints(2);
        
    } 
    
    /**
     * Test plotting of three points.
     */
    @Test
    public void testThreePoints()
    {        
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();        
        
        checkOnePoint(20, 200);
        checkNumberOfPoints(1);
        checkOnePoint(200, 30);
        checkNumberOfPoints(2);
        checkOnePoint(144, 144);
        checkNumberOfPoints(3);    
        
    }   
    
    /**
     * Test plotting of many points.
     */
    @Test
    public void testManyPoints()
    {        
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();                
        checkMultiplePoints();  
        
    }
    
    /**
     * Make sure plotting exits properly with out of bounds
     * data.
     */
    @Test
    public void testPlotPointsExit()
    {
        //Clear the canvas then do some testing.
        Canvas.getCanvas().resetCanvas();
        checkPlotPointsExit();
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
            fb += "Failure in TestActivity3 while checking plotPoints().\n";
            fb += "This test has plotted " + expected + " point(s).\n";
            fb += "Your graph has " + found + " point(s).\n";
            fb += "Make sure you are only plotting points as taken from\n";
            fb += "the keyboard in plotPoints().\n";
            fail(fb);            
        }
        
        if (found  < expected)
        {
            fb += "Failure in TestActivity3 while checking plotPoints().\n";
            fb += "This test has plotted " + expected + " point(s).\n";
            fb += "Your graph has " + found + "point(s).";
            fb += "Make sure you are plotting ALL points that are not out\n";
            fb += "of bounds.\n";
            fail(fb);            
        }
    }
    
    /**
     * Check all possible reasons the while loop should
     * exit in plotPoints().
     */
    public void checkPlotPointsExit()
    {
        checkPlotPointsExit(-1, 100);        
        checkPlotPointsExit(100, -1);        
        checkPlotPointsExit(10, 291);        
        checkPlotPointsExit(291, 10);        
    }
    
    /**
     * Make sure plotPoints() exits on an out of bounds value.
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
            plotter.plotPoints(input);
        }
        catch (NoSuchElementException e)
        {
            
            fb += "Failure in TestActivity3 while checking plotPoints.\n";
            fb += "Your while loop doesn't exit correctly using point ";
            fb += "(" + x + ", " + y + ").";
            fail(fb);
        }     
        
        int found = Canvas.getCanvas().getCircles().size();
        
        if (found  != 0)
        {
            fb += "Failure in TestActivity3 while checking plotPoints().\n";
            fb += "You plotted an offscreen point.  Do not point plots\n";
            fb += "that have an x or y coordinate that is less than 0 or\n";
            fb += "greater than 290.";
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
        Scanner input = new Scanner(x + "\n" + y + "\n-10\n-10\n");

        plotter.plotPoints(input);
        ArrayList<Circle> circles = Canvas.getCanvas().getCircles();
        
        if (circles.size() == 0)
        {
            fb += "Failure in TestActivity3 while testing plotPoints()\n";
            fb += "When plotting point (" + x + ", " + y 
                + "), plotPoints() failed to create ANY circles.\n";
            fail(fb);
        }

        if (!canFindPoint(x, y, circles))
        {
            fb += "Failure in TestActivity3 while testing plotPoints()\n";
            fb += "Plotted (" + x + ", " + y + ") in plotPoints().\n";
            fb += "None of the current circles on the graph have ";
            fb += "have those x,y cordinates.\n";
            fb += "Make sure you are graphing all valid points.\n";
            fb += "Check to see that you don't have your x and y mixed up\n";
            fb += "when creating the circles.\n";
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
        inputString += "144\n144\n144\n64\n64\n144\n144\n224\n224\n144\n";
        inputString += "64\n64\n224\n64\n64\n224\n224\n224\n";
        inputString += "-1\n-1\n";
        Scanner input = new Scanner(inputString);
        plotter.plotPoints(input);
        checkNumberOfPoints(9);
        
        ArrayList<Circle> circles = Canvas.getCanvas().getCircles();
        fb += "Failure in TestActivity3 while testing plotPoints()\n";

        if (!canFindPoint(144, 144, circles) 
            || !canFindPoint(144, 64, circles)
            || !canFindPoint(64, 144, circles)
            || !canFindPoint(144, 224, circles)
            || !canFindPoint(224, 144, circles) 
            || !canFindPoint(64, 64, circles)
            || !canFindPoint(64, 224, circles)
            || !canFindPoint(224, 64, circles)
            || !canFindPoint(224, 224, circles) 
            )
        {
            fb += "Failure in TestActivity3 while testing plotPoints()\n";
            fb += "Printed five points.  One or more did not show\n";
            fb += "up on your graph at the correct position.\n";
            fail(fb);
        }
        
    }
       
    /**
     * Search the given circle array for a circle with the given x and y
     * coordinates.
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
