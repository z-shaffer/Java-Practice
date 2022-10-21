/**
 * TestPatternsIntro.java
 *
 * @author Joel Swanson, Julia Dana
 * @version 2014-04-07
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.Scanner;

/**
 * Check the PatternsIntro class.
 * 
 * @author Julia Dana
 * @version 2014-04-07
 */
public class TestPatternsIntro
{
    /**
     * Checks that the expected number of squares are at each x position.
     */
    @Test
    public void checkAllXPositions()
    {
        Canvas c = Canvas.getCanvas();
        c.clear();
        PatternsIntro tp0 = new PatternsIntro();

        for (int i = 0; i < 10; i++)
        {
            int expectedInColumn = 4;
            if (i > 7)
            {
                expectedInColumn = 3;
            }

            assertEquals("You don't have the correct number of squares"
                + " in column " + (i + 1),
                expectedInColumn, c.countSquaresAtX(100 + (50 * i)));
        }

    }

    /**
     * Check that the correct squares are created by tenSquaresWhileLoop.
     */
    @Test
    public void checkTenSquaresWhileLoopSquares()
    {

        Canvas c = Canvas.getCanvas();
        c.clear();
        PatternsIntro tp0 = new PatternsIntro();
     

        //Make sure there are 10 red squares
        assertEquals("You don't have 10 red squares\n", 
            10, c.countSquaresByColor("red"));

        //Make sure they didn't modify the original blue.
        assertEquals("You don't have the original blue squares.\n", 
            10, c.countSquaresByColor("blue"));

        assertEquals("You don't have the correct number of"
            + " Squares in this row.",
            10, c.countSquaresAtY(200));
            
        // TODO: Check square sizes.
        
        // Check after resetting and just running the method
        c.clear();
        tp0.tenSquaresWhileLoop();
        
        //Make sure there are 10 red squares
        assertEquals("You don't have 10 red squares\n", 
            10, c.countSquaresByColor("red"));
            
        assertEquals("You don't have the correct number of"
            + " Squares in this row.",
            10, c.countSquaresAtY(200));
    }  

    /**
     * Make sure a while loop was used and a for loop was not used.
     */

    @Test
    public void checkTenSquaresWhileLoopType()    
    {
        //Make sure the word while appears in the method.
        assertTrue("You did not use a while loop.\n", 
            findWordInMethod("PatternsIntro.java",
                "tenSquaresWhileLoop", "while"));

        //Make sure the word for does not appear in the method.
        assertTrue("Found a for loop in tenSquaresWhileLoop\n",
            !findWordInMethod("PatternsIntro.java",
                "tenSquaresWhileLoop", "for (")
            && !findWordInMethod("PatternsIntro.java",
                "tenSquaresWhileLoop", "for(")
        );          
    }
    
    /**
     * Check that the correct squares are created by tenSquaresForLoop.
     */
    @Test
    public void checkTenSquaresForLoopSquares()
    {

        Canvas c = Canvas.getCanvas();
        c.clear();
        PatternsIntro tp0 = new PatternsIntro();

        //Make sure there are 10 red squares
        assertEquals("You don't have 10 green squares\n", 
            10, c.countSquaresByColor("green"));

        //Make sure they didn't modify the original blue.
        assertEquals("You don't have the original blue squares.\n", 
            10, c.countSquaresByColor("blue"));

        assertEquals("You don't have the correct number of"
            + " Squares in this row.",
            10, c.countSquaresAtY(250));
            

        // TODO: Check square sizes.
        
        // Check after resetting and just running the method
        c.clear();
        tp0.tenSquaresForLoop();
        
        //Make sure there are 10 red squares
        assertEquals("You don't have 10 green squares\n", 
            10, c.countSquaresByColor("green"));
            
        assertEquals("You don't have the correct number of"
            + " Squares in this row.",
            10, c.countSquaresAtY(250));
    }  

    /**
     * Make sure a for loop was used and a while loop was not used.
     */
    @Test
    public void checkTenSquaresForLoopType()    
    {
        //Make sure the word for appears in the method.
        assertTrue("You did not use a for loop.\n", 
            findWordInMethod("PatternsIntro.java",
                "tenSquaresForLoop", "for (")
            || findWordInMethod("PatternsIntro.java",
                "tenSquaresForLoop", "for("));

        //Make sure the word for does not appear in the method.
        assertTrue("Found a while loop in tenSquaresForLoop\n",
            !findWordInMethod("PatternsIntro.java",
                "tenSquaresForLoop", "while"));          
    }
    
    /**
     * Check that the correct squares are created by rowOfSquares.
     */
    @Test
    public void checkRowOfSquaresSquares()
    {

        Canvas c = Canvas.getCanvas();
        c.clear();
        PatternsIntro tp0 = new PatternsIntro();

        //Make sure there are 10 red squares
        assertEquals("You don't have 8 black squares\n", 
            8, c.countSquaresByColor("black"));

        //Make sure they didn't modify the original blue.
        assertEquals("You don't have the original blue squares.\n", 
            10, c.countSquaresByColor("blue"));

        assertEquals("You don't have the correct number of"
            + " Squares in this row.",
            8, c.countSquaresAtY(300));
       
        // Check that rowOfSquares uses its parameters.
        c.clear();
        tp0.rowOfSquares(4, "cyan", 0, 0, 5, 25);
        
        if (c.countSquaresByColor("cyan") != 4
                || c.countSquaresAtY(0) != 4
                || c.countSquaresAtX(0) != 1
                || c.countSquaresAtX(30) != 1
                || c.countSquaresAtX(60) != 1
                || c.countSquaresAtX(90) != 1)
        {
            // TODO: Check square sizes.
            fail("Does not use parameters correctly");
        }
    }  

    /**
     * Make sure a loop was used.
     */

    @Test
    public void checkRowOfSquaresLoopType()    
    {
        //Make sure the word while appears in the method.
        assertTrue("You did not use a loop.\n", 
            findWordInMethod("PatternsIntro.java",
                "rowOfSquares", "while")
            || findWordInMethod("PatternsIntro.java",
                "rowOfSquares", "for (")                
            || findWordInMethod("PatternsIntro.java",
                "rowOfSquares", "for("));   
    }

    /**
     * Check a specified method in a specified file for a particular
     * word.
     * @param filename The name of the file with the method that needs
     * checked.
     * @param method The name of the method inside of the file that
     * needs checked.
     * @param word The word to search for inside of the method.
     * @return Returns true if the word is found in the named method. Returns
     * false if the word is not found.
     */
    private boolean findWordInMethod(String filename, 
                        String method, String word)    
    {
        boolean found = false;
        try 
        {
            java.io.File file = new java.io.File(filename);

            if (file.exists())
            {
                Scanner filescan = new Scanner(file);
                while (!found && filescan.hasNext())
                {
                    String input = filescan.nextLine();
                    if (input.contains(" " + method + "("))
                    {
                        while (!input.contains(")"))
                        {
                            input = filescan.nextLine();
                        }
                        found = foundInMethod(filescan, word);
                    }
                }                
            }
        }
        catch (java.io.FileNotFoundException e)
        {
            System.out.println("Can't find file.");
        }
        return found;
    }

    /**
     * Takes a scanner object and a word to find within that method.
     * The scanner has previously been read until the proper method
     * was found and the next line read should be the opening brace
     * of the requested method. Lines are read and checked for the
     * given word until the ending brace is encounterd.
     * 
     * @param scanner The scanner to read from.  This scanner is 
     * positioned to read the first line inside of the method.
     * @param find The string to find before the end of the method
     * is reached.
     * @return Returns true if the given word is found before the 
     * method closing brace.  Returns false if the word is not found
     * before the closing brace.
     */
    private boolean foundInMethod(Scanner scanner, String find)
    {
        String input = "";
        int count = 0;
        boolean found = false;

        input = scanner.nextLine();
        if (input.indexOf("{") >= 0)
        {
            count++;
        }

        while (!found && count > 0)
        {
            input = scanner.nextLine();
            //Count the braces.  Opens add, closes subtract.
            //When the count reaches zero it marks the end
            //of the method.
            if (input.indexOf("{") >= 0)
            {
                count++;
            }
            else if (input.indexOf("}") >= 0)
            {
                count--;
            }

            if (input.indexOf(find) >= 0)
            {
                found = true;
            }
        }
        return found;
    }
}
