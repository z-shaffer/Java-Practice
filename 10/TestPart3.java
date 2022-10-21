import static org.junit.Assert.fail;
import org.junit.Test;
import java.awt.Image;
import java.awt.image.BufferedImage;
/**
 * Create tick marks on the x and y axis.
 *
 * @author Joel Swanson
 * @version 02.15.2014
 */
public class TestPart3
{
    private TestPart1A tp1;
    private TestPart1B tp2;
    private TestPart2 ta1;

    private int numberOfSquares = 0;
    private int offscreenSquares = 0;
    private int blackCount = 0;
    private int redCount = 0;
    private int yellowCount = 0;
    private int blueCount = 0;
    private int whiteCount = 0;
    private int otherCount = 0;    


    
        
    /**
     * Run all tests.
     */
    @Test
    public void testXTick()
    {        
        //Clear the canvas then do some testing.
        Canvas canvas = Canvas.getCanvas();        
        canvas.resetCanvas();
        checkXTick();

    }        
    /**
     * Run all tests.
     */
    @Test
    public void testYTick()
    {        
        //Clear the canvas then do some testing.
        Canvas canvas = Canvas.getCanvas();        
        canvas.resetCanvas();
        checkYTick();
                
    }        
    /**
     * Run all tests.
     */
    @Test
    public void testAllXTicks()
    {        
        //Clear the canvas then do some testing.
        Canvas canvas = Canvas.getCanvas();        
        canvas.resetCanvas();        
        checkAllXTicks();        
    }        
    /**
     * Run all tests.
     */
    @Test
    public void testAllYTicks()
    {        
        //Clear the canvas then do some testing.
        Canvas canvas = Canvas.getCanvas();                
        canvas.resetCanvas();
        
        //Have to draw X ticks otherwise color counts will be
        //off on Y ticks.
        checkAllXTicks();
        checkAllYTicks();
        
    }        


    /**
     * Check x tick.  Make sure drawOneXTick(int) draws
     * a tick at the correct position.
     */
    public void checkXTick()
    {
        String fb = "";
        Plotter plotter = new Plotter();   
        plotter.drawOneXTick(167);
        plotter.drawOneXTick(247);
        
        updateImageData();
        if (whiteCount != 81929)
        {
            fb += "Activity 2 drawOneXTick() failure.\n";
            fb += "You have drawn a shape to the screen where\n";
            fb += "it should not be.  When drawing the axes, you\n";
            fb += "should only overwrite green pixels.\n";
            fail(fb);                        
        }
        
        if (offscreenSquares > 0)
        {
            fb += "Activity 2 drawOneXTick() failure.\n";
            fb += "You have drawn extra squares beyond the\n";
            fb += "edges of the screen.  Be careful that your\n";
            fb += "for loops do not start too early or go to far.\n";
            fb += "The x and y position of ALL squares MUST be from\n";
            fb += "0 to 299, including 0 and 299.\n";
            fail(fb);            
        }
        
        if (numberOfSquares > 10)
        {
            fb += "Activity 2 drawOneXTick() failure.\n";
            fb += "You have drawn too many squares.  Be careful\n";
            fb += "not to overlap squares.  Adjust the distance between\n";
            fb += "squares until you just see a single line of pixels\n";
            fb += "and then reduce that value by 1 to form a solid line.";
            fail(fb);
        }   
        
        if (yellowCount != 5525)
        {
            fb += "Activity 2 drawOneXTick() failure.\n";
            fb += "This test should have covered exactly two green\n";
            fb += "tick marks with black tick marks.  Yours did not.\n";
            fb += "Check for alignment errors top to bottom and left\n";
            fb += "to right.\n";
            fail(fb);            
        }

        if (redCount != 2296)
        {
            fb += "Activity 2 drawOneXTick() failure.\n";
            fb += "This test should have covered exactly two green\n";
            fb += "tick marks with black tick marks and should NOT\n";
            fb += "have covered any red pixels.  Yours covered red\n";
            fb += "pixels. Check to see if your tick mark is too long\n";
            fb += "top to bottom or too wide left to right.\n";
            fail(fb);            
        }  
        
        //Make sure the two green tick marks covered are the correct two.
        if (Canvas.getCanvas().countSquaresAtX(167) != 5)
        {
            fb += "Activity 2 drawOneXTick() failure.\n";
            fb += "A black tick was created and was placed over\n";
            fb += "a green tick.  However, it was placed over the\n";
            fb += "wrong tick.  Calling drawOneXTick(0); should place\n";
            fb += "the tick all the way to the left side of the canvas.\n";
            fail(fb);              
        }

        if (Canvas.getCanvas().countSquaresAtX(247) != 5)
        {
            fb += "Activity 2 drawOneXTick() failure.\n";
            fb += "A black tick was created and was placed over\n";
            fb += "a green tick.  However, it was placed over the\n";
            fb += "wrong tick.  Calling drawOneXTick(0); should place\n";
            fb += "the tick all the way to the left side of the canvas.\n";
            fail(fb);              
        }
    }
    
    /**
     * Check y tick.  Make sure drawOneYTick(int) draws
     * a tick at the correct position.
     */
    public void checkYTick()
    {
        String fb = "";
        Plotter plotter = new Plotter();   
        plotter.drawOneYTick(167);
        plotter.drawOneYTick(247);
        
        updateImageData();
        
        if (whiteCount != 81929)
        {
            fb += "Activity 2 drawOneYTick() failure.\n";
            fb += "You have drawn a shape to the screen where\n";
            fb += "it should not be.  When drawing the axes, you\n";
            fb += "should only overwrite green pixels.\n";
            fail(fb);                        
        }
        
        if (offscreenSquares > 0)
        {
            fb += "Activity 2 drawOneYTick() failure.\n";
            fb += "You have drawn extra squares beyond the\n";
            fb += "edges of the screen.  Be careful that your\n";
            fb += "for loops do not start too early or go to far.\n";
            fb += "The x and y position of ALL squares MUST be from\n";
            fb += "0 to 299, including 0 and 299.\n";
            fail(fb);            
        }
        
        if (numberOfSquares > 10)
        {
            fb += "Activity 2 drawOneYTick() failure.\n";
            fb += "You have drawn too many squares.  Be careful\n";
            fb += "not to overlap squares.  Adjust the distance between\n";
            fb += "squares until you just see a single line of pixels\n";
            fb += "and then reduce that value by 1 to form a solid line.";
            fail(fb);
        }   
        
        if (yellowCount != 5525)
        {
            fb += "Activity 2 drawOneYTick() failure.\n";
            fb += "This test should have covered exactly two green\n";
            fb += "tick marks with black tick marks.  Yours did not.\n";
            fb += "Check for alignment errors top to bottom and left\n";
            fb += "to right.\n";
            fail(fb);            
        }

        if (redCount != 2296)
        {
            fb += "Activity 2 drawOneYTick() failure.\n";
            fb += "This test should have covered exactly two green\n";
            fb += "tick marks with black tick marks and should NOT\n";
            fb += "have covered any red pixels.  Yours covered red\n";
            fb += "pixels. Check to see if your tick mark is too long\n";
            fb += "top to bottom or too wide left to right.\n";
            fail(fb);            
        }       
        
        //Make sure the two green tick marks covered are the correct two.
        if (Canvas.getCanvas().countSquaresAtY(167) != 5)
        {
            fb += "Activity 2 drawOneYTick() failure.\n";
            fb += "A black tick was created and was placed over\n";
            fb += "a green tick.  However, it was placed over the\n";
            fb += "wrong tick.  Calling drawOneYTick(0); should place\n";
            fb += "the tick all the way at the top of the canvas.\n";
            fail(fb);              
        }

        if (Canvas.getCanvas().countSquaresAtY(247) != 5)
        {
            fb += "Activity 2 drawOneYTick() failure.\n";
            fb += "A black tick was created and was placed over\n";
            fb += "a green tick.  However, it was placed over the\n";
            fb += "wrong tick.  Calling drawOneYTick(0); should place\n";
            fb += "the tick all the way at the top of the canvas.\n";
            fail(fb);              
        }        
    }    
    
    /**
     * Test the x axis drawing loop.
     */
    public void checkAllXTicks()
    {
        String fb = "";
        Plotter plotter = new Plotter();        
        plotter.drawXAxis();
        plotter.drawAllXTicks();
        updateImageData();
        
        if (whiteCount != 81929)
        {
            fb += "Activity 2 drawAllXTicks() failure.\n";
            fb += "You have drawn a shape to the screen where\n";
            fb += "it should not be.  When drawing the axes, you\n";
            fb += "should only overwrite green pixels.\n";
            fail(fb);                        
        }        
        
        if (offscreenSquares > 0)
        {
            fb += "Activity 2 drawAllXTicks() failure.\n";
            fb += "You have drawn extra squares beyond the\n";
            fb += "edges of the screen.  Be careful that your\n";
            fb += "for loops do not start too early or go to far.\n";
            fb += "The x and y position of ALL squares MUST be from\n";
            fb += "0 to 299, including 0 and 299.\n";
            fail(fb);            
        }
        
        if (numberOfSquares > 135)
        {
            fb += "Activity 2 drawAllXTicks() failure.\n";
            fb += "You have drawn too many squares.  Be careful\n";
            fb += "not to overlap squares.  Adjust the distance between\n";
            fb += "squares until you just see a single line of pixels\n";
            fb += "and then reduce that value by 1 to form a solid line.";
            fail(fb);
        }   
        
        if (yellowCount != 2775)
        {
            fb += "Activity 2 drawAllXTicks() failure.\n";
            fb += "Your ticks are not perfectly alligned.  They\n";
            fb += "should exactly cover all of the green ticks\n";
            fb += "on the x axis. Check the alignment both up\n";
            fb += "and down and left to right.";
            fail(fb);            
        }
        
        if (redCount != 2296)
        {
            fb += "Activity 2 drawAllXTicks() failure.\n";
            fb += "This test should have covered all green\n";
            fb += "tick marks  on the x axis with black tick\n";
            fb += "marks and should NOT have covered any red \n";
            fb += "pixels.  Yours covered red pixels. Check to \n";
            fb += "see if your tick mark is too long top to\n";
            fb += "bottom or too wide left to right.\n";
            fail(fb);            
        }
    }
    
    /**
     * Test the y axis drawing loop.
     */
    public void checkAllYTicks()
    {
        String fb = "";
        Plotter plotter = new Plotter();        
        plotter.drawYAxis();
        plotter.drawAllYTicks();
        updateImageData();
        
        if (whiteCount != 81929)
        {
            fb += "Activity 2 drawAllYTicks() failure.\n";
            fb += "You have drawn a shape to the screen where\n";
            fb += "it should not be.  When drawing the axes, you\n";
            fb += "should only overwrite green pixels.\n";
            fail(fb);                        
        }        

        if (offscreenSquares > 0)
        {
            fb += "Activity 2 drawAllYTicks() failure.\n";
            fb += "You have drawn extra squares beyond the\n";
            fb += "edges of the screen.  Be careful that your\n";
            fb += "for loops do not start too early or go to far.\n";
            fb += "The x and y position of ALL squares MUST be from\n";
            fb += "0 to 299, including 0 and 299.\n";
            fail(fb);            
        }
        
        if (numberOfSquares > 270)
        {
            fb += "Activity 2 drawAllYTicks() failure.\n";
            fb += "You have drawn too many squares.  Be careful\n";
            fb += "not to overlap squares.  Adjust the distance between\n";
            fb += "squares until you just see a single line of pixels\n";
            fb += "and then reduce that value by 1 to form a solid line.";
            fail(fb);
        }   
        
        if (yellowCount != 0)
        {
            fb += "Activity 2 drawAllYTicks() failure.\n";
            fb += "This test should have covered exactly all green\n";
            fb += "tick marks with black tick marks and should NOT\n";
            fb += "have covered any red pixels.  Check alignment\n";
            fb += "top to bottom and left to right.\n";
            fail(fb);            
        }
        
        if (redCount != 2296)
        {
            fb += "Activity 2 drawAllYTicks() failure.\n";
            fb += "This test should have covered exactly all green\n";
            fb += "tick marks with black tick marks and should NOT\n";
            fb += "have covered any red pixels.  Yours covered red\n";
            fb += "pixels. Check to see if your tick marks are too long\n";
            fb += "top to bottom or too wide left to right.\n";
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
