import static org.junit.Assert.fail;
import org.junit.Rule;
import org.junit.rules.Timeout;
import org.junit.Test;
import java.awt.Image;
import java.awt.image.BufferedImage;
/**
 * Create the x and y axis lines using for loops.
 *
 * @author Joel Swanson
 * @version 02.13.2014
 */
public class TestPart2
{
    //30 seconds max per method tested
    @Rule
    public Timeout globalTimeout = new Timeout(30000);  
    
    
    private TestPart1A tp1;
    private TestPart1B tp2;
    private int grade;
    private int circleStyleErrors;
    private int squareStyleErrors;
    private int plotterStyleErrors;    

    private int numberOfSquares = 0;
    private int offscreenSquares = 0;
    private int blackCount = 0;
    private int redCount = 0;
    private int yellowCount = 0;
    private int blueCount = 0;
    private int whiteCount = 0;
    private int otherCount = 0;    
    
    
        
    /**
     * Test X axis.
     */
    @Test
    public void testXAxis()
    {        
        //Clear the canvas then do some testing.
        Canvas canvas = Canvas.getCanvas();        
        canvas.resetCanvas();
        checkXAxis();        
    }        

    /**
     * Test Y axis.
     */
    @Test
    public void testYAxis()
    {        
        //Clear the canvas then do some testing.
        Canvas canvas = Canvas.getCanvas();        
        canvas.resetCanvas();
        
        //Have to draw X axis or it will throw color counts
        //off when checking y Axis.
        checkXAxis();        
        checkYAxis();
    }        

    /**
     * Test the x axis drawing loop.
     */
    public void checkXAxis()
    {
        String fb = "";
        Plotter plotter = new Plotter();        
        plotter.drawXAxis();
        updateImageData();
        if (offscreenSquares > 0)
        {
            fb += "Activity 1 failure when drawing the x axis.\n";
            fb += "You have drawn extra squares beyond the\n";
            fb += "edges of the screen.  Be careful that your\n";
            fb += "for loops do not start too early or go to far.\n";
            fb += "The x and y position of ALL squares MUST be from\n";
            fb += "0 to 299, including 0 and 299.\n";
            fail(fb);            
        }
        
        if (numberOfSquares > 60)
        {
            fb += "Activity 1 failure when drawing the x axis.\n";
            fb += "You have drawn too many squares.  Be careful\n";
            fb += "not to overlap squares.  Adjust the distance between\n";
            fb += "squares until you just see a single line of pixels\n";
            fb += "and then reduce that value by 1 to form a solid line.";
            fail(fb);
        }          
          
        if (numberOfSquares < 60)
        {
            fb += "Activity 1 failure when drawing the x axis.\n";
            fb += "You have not drawn enough squares.  You are only\n";
            fb += "allowed to use 5x5 squares.\n";
            fail(fb);
        }      
        
        if (yellowCount != 4275 || redCount != 2296)
        {
            fb += "Activity 1 failure when drawing the x axis.\n";
            fb += "Your x axis is not perfecty aligned.  It should cover\n";
            fb += "all of the green pixels along the x axis but should\n";
            fb += "NOT be covering any of the red.  Move your line up\n";
            fb += "or down by a pixel and retest.";
            fail(fb);            
        }

        
    }
    
    /**
     * Test the y axis drawing loop.
     */
    public void checkYAxis()
    {
        String fb = "";
        Plotter plotter = new Plotter();        
        plotter.drawYAxis();
        updateImageData();
        if (offscreenSquares > 0)
        {
            fb += "Activity 1 failure when drawing the y axis.\n";
            fb += "You have drawn extra squares beyond the\n";
            fb += "edges of the screen.  Be careful that your\n";
            fb += "for loops do not start too early or go to far.\n";
            fb += "The x and y position of ALL squares MUST be from\n";
            fb += "0 to 299, including 0 and 299.\n";
            fail(fb);            
        }
        
        if (numberOfSquares > 120)
        {
            fb += "Activity 1 failure when drawing the y axis.\n";
            fb += "You have drawn too many squares.  Be careful\n";
            fb += "not to overlap squares.  Adjust the distance between\n";
            fb += "squares until you just see a single line of pixels\n";
            fb += "and then reduce that value by 1 to form a solid line.";
            fail(fb);
        }   
                
        if (numberOfSquares < 120)
        {
            fb += "Activity 1 failure when drawing the y axis.\n";
            fb += "You have not drawn enough squares.  You are only\n";
            fb += "allowed to use 5x5 squares.\n";
            fail(fb);
        }         
        
        if (yellowCount != 2800 || redCount != 2296)
        {
            fb += "Activity 1 failure when drawing the y axis.\n";
            fb += "Your y axis is not perfecty aligned.  It should\n";
            fb += "cover the green pixels along the y axis but should\n";
            fb += "NOT be covering any of the red.  Move your line left\n";
            fb += "or right by a pixel and retest.";
            fail(fb);            
        }
        
        
    }
    
    /**
     * Count the various pixel count of colors and number
     * of squares on the screen.
     */
    private void updateImageData()
    {
        Canvas canvas = Canvas.getCanvas();             
        Image i = canvas.getCanvasImage();
        BufferedImage bi = (BufferedImage) i;
        checkImage(bi);       
    }
    
    /**
     * Count all of the pixels grouped by color on this image.
     * 
     * @param img The image to get the pixel data from.
     */
    public void checkImage(BufferedImage img)
    {
        numberOfSquares = 0;
        offscreenSquares = 0;
        blackCount = 0;
        redCount = 0;
        yellowCount = 0;
        blueCount = 0;
        whiteCount = 0;
        otherCount = 0;          
        
        try 
        {
    
            int[][] pixelData = new int[img.getHeight() * img.getWidth()][3];
            int[] rgb;
    
            
            for (int i = 0; i < img.getHeight(); i++)
            {
                for (int j = 0; j < img.getWidth(); j++)
                {
                    rgb = getPixelData(img, i, j);    
                }
            }
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        numberOfSquares = Canvas.getCanvas().countShapesByColor("black");
        offscreenSquares = Canvas.getCanvas().countOffscreenSquares();
        /*
        System.out.println("Black " + blackCount);
        System.out.println("White " + whiteCount);
        System.out.println("Red " + redCount);
        System.out.println("Green " + greenCount);
        System.out.println("Blue " + blueCount);
        System.out.println("Black Object Count: " + numberOfSquares);
        System.out.println("Offscreen Squares Count: " + offscreenSquares);
        */
    }

    /**
     * Determine the color of a specific pixel and add
     * it to a count for that color.
     * 
     * @param img The image which is the canvas view.
     * @param x The x value of the pixel to check.
     * @param y The y value of the pixel to check.
     * 
     * @return Returns an array with the rgb values divided.
     */
    private  int[] getPixelData(BufferedImage img, int x, int y) 
    {
        int argb = img.getRGB(x, y);
    
        int rgb[] = new int[] 
        {
            //red
            (argb >> 16) & 0xff, 

            //green
            (argb >>  8) & 0xff, 
            
            //blue
            (argb) & 0xff  
        };
    
        if (rgb[0] == 0 && rgb[1] == 0 && rgb[2] == 0)
        {        
            blackCount++;
        }
        else if (rgb[0] > 0 && rgb[1] == 0 && rgb[2] == 0)
        {
            redCount++;
        }
        else if (rgb[0] > 0 && rgb[1] > 0 && rgb[2] == 0)
        {
            yellowCount++;
        }
        else if (rgb[0] == 0 && rgb[1] == 0 && rgb[2] > 0)
        {
            blueCount++;
        }
        else if (rgb[0] > 0 && rgb[1] > 0 && rgb[2] > 0)
        {
            whiteCount++;
        }
        else
        {
            otherCount++;
        }
        return rgb;
    }    
    
}
