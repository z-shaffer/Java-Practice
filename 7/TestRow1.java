 

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Scanner;
import org.junit.Rule;
import org.junit.rules.Timeout;        

/**
 * The test class TestRowActivity2.
 *
 * @author  Julia Dana
 * @version 2014-04-09
 */
public class TestRow1
{

    @Rule
    public Timeout globalTimeout = new Timeout(10000);    
    
    /**
     * Performs a high-level check of the no-arg constructor for a Row.
     */
    @Test
    public void testNoArgConstructor()
    {
        Canvas c = Canvas.getCanvas();
        c.clear();
        long initTime = System.currentTimeMillis();
        
        Row r = new Row();
        
        long afterTime = System.currentTimeMillis();
        
        assertEquals("You don't have 4 red squares\n", 
            4, c.countSquaresByColor("red"));
            
        assertEquals("You don't have 4 black squares\n", 
            4, c.countSquaresByColor("black"));
            
        ArrayList<Square> squares = r.getSqList();
        for (int i = 0; i < 8; i++)
        {
            Square s = squares.get(i);
            if (i % 2 == 0)
            {
                assertTrue("Even squares (starting from 0) should be black",
                    s.getColor().equals("black"));
            }
            else
            {
                assertTrue("Odd squares (starting from 1) should be red",
                    s.getColor().equals("red"));
            }
            
            assertEquals("Squares were not the expected size.", 
                48, s.getSize());
        }
        
        assertEquals("You don't have the correct number of Squares"
            + " in this row, or the row is misplaced.",
            8, c.countSquaresAtY(0));
            
            
        for (int i = 0; i < 8; i++)
        {
            int expectedInColumn = 1;

            assertEquals("You don't have the correct number of"
                + "squares in column " + (i + 1),
                expectedInColumn, c.countSquaresAtX((50 * i)));
        }
        
        assertTrue("Constructor did not delay enough between stages.", 
            950 < (afterTime - initTime));
    }
    
    /**
     * Test the addSquaresToList method.
     */
    @Test
    public void testAddSquaresToList()
    {
        Canvas c = Canvas.getCanvas();
        c.clear();        
        Row r = new Row();
        c.clear();
        r.setSqList(new ArrayList<Square>());
        
        r.addSquaresToList();
        
        ArrayList<Square> squares = r.getSqList();
        
        assertEquals("Did not add the correct number of squares.", 
            8, squares.size());
        
        for (Square s : squares)
        {
            if (s.getSize() != 50
                || s.getColor() != "red"
                || s.getY() != 0
                || s.getX() % 50 != 0)
            {
                fail("Did not create squares with the correct parameters.");
            }
        }
    }
    
    /**
     * Tests that the changeSquareSize method changes the size
     * of all the squares in the row.
     */
    @Test
    public void testChangeSquareSize()
    {
        Canvas c = Canvas.getCanvas();
        c.clear();        
        Row r = new Row();
        r.changeSquareSize(15);
        
        ArrayList<Square> squares = r.getSqList();
        
        for (Square s : squares)
        {
            if (s.getSize() != 15)
            {
                fail("Did not change the size to the given size.");
            }
        }
    }
    
    /**
     * Tests that the changeEvenToBlack method changes 
     * all even squares to black.
     */
    @Test
    public void testChangeEvenToBlack()
    {
        Canvas c = Canvas.getCanvas();
        c.clear();        
        Row r = new Row();
        
        ArrayList<Square> squares = new ArrayList<Square>();
        for (int i = 0; i < 12; i++)
        {
            squares.add(new Square(0, i * 30, 25, "cyan"));
        }
        
        r.setSqList(squares);
        r.changeEvenToBlack();
        ArrayList<Square> newSquares = r.getSqList();
        
        for (int i = 0; i < 12; i++)
        {
            Square s = newSquares.get(i);
            
            if (i % 2 == 0)
            {
                assertTrue("Expected even squares to be black"
                    + " for any size list.",
                    s.getColor().equals("black"));
            }
            else
            {
                assertTrue("Expected odd squares to be the original color.", 
                    s.getColor().equals("cyan"));
            }
        }
    }
    
    /**
     * Tests that the changeOddToBlack method changes all the odd
     * squares in the row to black.
     */
    @Test
    public void testChangeOddToBlack()
    {
        Canvas c = Canvas.getCanvas();
        c.clear();        
        Row r = new Row();
        
        ArrayList<Square> squares = new ArrayList<Square>();
        for (int i = 0; i < 12; i++)
        {
            squares.add(new Square(0, i * 30, 25, "cyan"));
        }
        
        r.setSqList(squares);
        r.changeOddToBlack();
        ArrayList<Square> newSquares = r.getSqList();
        
        for (int i = 0; i < 12; i++)
        {
            Square s = newSquares.get(i);
            
            if (i % 2 == 1)
            {
                assertTrue("Expected odd squares to be black"
                    + " for any size list.",
                    s.getColor().equals("black"));
            }
            else
            {
                assertTrue("Expected even squares to be the original color.", 
                    s.getColor().equals("cyan"));
            }
        }
    }
    
    /**
     * Tests that the delay method functions correctly.
     */
    @Test
    public void testDelay()
    {
        Canvas c = Canvas.getCanvas();
        c.clear();        
        Row r = new Row();
        
        int[] expectedDelays = {400, 1000};
        int acceptableDifference = 50;
        
        for (int delay : expectedDelays)
        {
            long timeBefore = System.currentTimeMillis();
            r.delay(delay);
            long timeAfter = System.currentTimeMillis();
        
            assertEquals(delay, timeAfter - timeBefore, acceptableDifference);
        }
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
