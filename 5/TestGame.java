import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import java.io.ByteArrayOutputStream;
import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.io.InputStream;
import java.util.Scanner;
/**
 * Tests employee class
 *
 * @author Brooke Tibbett
 * @version 9/3/2020
 */
public class TestGame
{
    private static final int GRID_I = 20;
    private static final int GRID_J = 20;
    private Game g;
    private Random random;
    private PrintStream oldSystemOut;
    private InputStream oldSystemIn;
    private ByteArrayOutputStream outContent;
    private String[] commands;
    
    public TestGame()
    {
        commands = new String[]{"up", "down", "left", "right"};
        
        g = null;
        oldSystemOut = null;
        oldSystemIn = null;
        random = new Random(System.currentTimeMillis()); 
        g = new Game();
    }

    @Before
    public void setUp()
    {
        oldSystemIn = System.in;
        oldSystemOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }
    
    /**
     * Tears down the test fixture.
     * 
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
        resetStreams();
    }

    /**
     * Resets I/O streams.
     */
    private void resetStreams()
    {
        System.setOut(oldSystemOut);
        System.setIn(oldSystemIn);
    }
    
    @Test
    public void checkInput()
    {        
        String exit = "exit";
        String inputString = "right\nright\ndown\ndown\n";

        for(int i = 0; i < 5; i++)
        {
            inputString += commands[random.nextInt(4)] + "\n";
        }
        
        String[] comm = inputString.split("\n");
        inputString += exit + "\n";
        ByteArrayInputStream inContent = 
                new ByteArrayInputStream(inputString.getBytes());

        System.setIn(inContent);

        // input is set, call the student's method!
        try 
        {
            g.main(null);
        }
        catch (java.util.InputMismatchException e) 
        {
            e.printStackTrace();
            fail("Your code did not expect the correct input (Strings).");
        }
        catch (java.util.NoSuchElementException e) 
        {
            e.printStackTrace();
            fail("Your code did not stop when exit was entered");
        }
        catch (java.lang.IllegalStateException e) 
        {
            e.printStackTrace();
            fail("In main, your Scanner malfunctioned; " 
                + "did it get closed somehow."
                + " \nView the exception details in the bottom section"  
                + " of your terminal window.");
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            fail("Your main method failed with an unknown exception. "
                + " \nView the exception details in the bottom section"  
                + " of your terminal window.");        
        }

        // okay, student code has run, now verify output
        String[] result = new String[5];
        result[0] = "Welcome! Your starting coordinates are (0, 0).";
        result[1] = "Acceptable commands are 'up', 'down'," 
            + " 'left', 'right' or 'exit'.";
        result[2] = "Next Move?";
        result[3] = "You are now on $$. Next?";
        result[4] = "Goodbye. You ended on $$.";

        Scanner output = new Scanner(outContent.toString());
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: No output?");
        }
        checkLine(output, "Welcome Line", result[0]);

        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Acceptable Commands");
        }
        checkLine(output, "Acceptable Commands Line", result[1]);
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Next Move? Line");
        }
        checkLine(output, "Next Move Line", result[2]);
        String curr = "(0, 0)";
        String coord = "";
        for(int i = 0; i < comm.length; i++)
        {
            coord = processCommand(comm[i], curr);
            if (!output.hasNextLine()) 
            {
                fail("Test for Game Failed: Didn't show output after command.");
            }
            checkLine(output, "Next Move Line", result[3].replace("$$", coord));
            curr = coord;
            checkGrid(output, coord);
        }
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Goodbye Line");
        }
        checkLine(output, "Goodbye Line", result[4].replace("$$", coord));
    }
    
    @Test
    public void checkInputOutOfBounds()
    {        
        String exit = "exit";

        String inputString = "left\nleft\nup\n";
        
        String[] comm = inputString.split("\n");
        inputString += exit + "\n";
        ByteArrayInputStream inContent = 
                new ByteArrayInputStream(inputString.getBytes());

        System.setIn(inContent);

        // input is set, call the student's method!
        try 
        {
            g.main(null);
        }
        catch (java.util.InputMismatchException e) 
        {
            e.printStackTrace();
            fail("Your code did not expect the correct input (Strings).");
        }
        catch (java.util.NoSuchElementException e) 
        {
            e.printStackTrace();
            fail("Your code did not stop when exit was entered");
        }
        catch (java.lang.IllegalStateException e) 
        {
            e.printStackTrace();
            fail("In main, your Scanner malfunctioned; " 
                + "did it get closed somehow."
                + " \nView the exception details in the bottom section"  
                + " of your terminal window.");
        }
        catch (Exception e) 
        {
            e.printStackTrace();
            fail("Your main method failed with an unknown exception. "
                + " \nView the exception details in the bottom section"  
                + " of your terminal window.");        
        }

        // okay, student code has run, now verify output
        String[] result = new String[5];
        result[0] = "Welcome! Your starting coordinates are (0, 0).";
        result[1] = "Acceptable commands are 'up', 'down'," 
            + " 'left', 'right' or 'exit'.";
        result[2] = "Next Move?";
        result[3] = "You are now on $$. Next?";
        result[4] = "Goodbye. You ended on $$.";

        Scanner output = new Scanner(outContent.toString());
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: No output?");
        }
        checkLine(output, "Welcome Line", result[0]);

        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Acceptable Commands");
        }
        checkLine(output, "Acceptable Commands Line", result[1]);
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Next Move? Line");
        }
        checkLine(output, "Next Move Line", result[2]);
        String curr = "(0, 0)";
        String coord = "";
        for(int i = 0; i < comm.length; i++)
        {
            coord = processCommand(comm[i], curr);
            if (!output.hasNextLine()) 
            {
                fail("Test for Game Failed: Didn't show output after command.");
            }
            checkLine(output, "Next Move Line", result[3].replace("$$", coord));
            curr = coord;
            checkGrid(output, coord);
        }
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Goodbye Line");
        }
        checkLine(output, "Goodbye Line", result[4].replace("$$", coord));
    }
    
    public void checkGrid2(Scanner output, int[] coords, int row)
    {
        String build = "";
        for(int i = 0; i < GRID_J; i++)
        {
            if(coords[0] == row && coords[1] == i)
            {
                build += "X";
            } else
            {
                build += "-";
            }
        }
        checkLine(output, "grid problem", build);
    }
    
    private void checkLine(Scanner output, String msg, String expected)
    {
        if (!output.hasNextLine()) 
        {
            fail("Missing " + msg);
        }
        String line = output.nextLine();
        if (!line.equals(expected))
        {
            fail(" " + msg + " is malformed.\n"
                + "Expected:  \"" + expected + "\"\n" 
                + "Your code: \"" + line + "\"\n");
        }
    }
  
    private String processCommand(String c, String current)
    {
        String[] coordStr = new String[2];
        try {
            coordStr = current.replace("(","").replace(")","").split(", ");
        } catch (NumberFormatException e)
        {
            fail("Your coordinates should be formatted like this: (x, y)");
        }
        int[] coord = new int[]{Integer.parseInt(coordStr[0])
                , Integer.parseInt(coordStr[1])};
        if(c.toUpperCase().equals("UP"))
        {
            if(coord[0] == 0)
            {
                return String.format("(%d, %d)", coord[0], coord[1]);
            } else
            {
                return String.format("(%d, %d)", coord[0] - 1, coord[1]);
            }
        }
        else if(c.toUpperCase().equals("DOWN"))
        {
            if(coord[0] == 20)
            {
                return String.format("(%d, %d)", coord[0], coord[1]);
            } else
            {
                return String.format("(%d, %d)", coord[0] + 1, coord[1]);
            }
        }
        else if(c.toUpperCase().equals("RIGHT"))
        {
            if(coord[1] == 20)
            {
                return String.format("(%d, %d)", coord[0], coord[1]);
            } else
            {
                return String.format("(%d, %d)", coord[0], coord[1] + 1);
            }
        }
        else if(c.toUpperCase().equals("LEFT"))
        {
            if(coord[1] == 0)
            {
                return String.format("(%d, %d)", coord[0], coord[1]);
            } else
            {
                return String.format("(%d, %d)", coord[0], coord[1] - 1);
            }
        }
        return "";
    }
    
    public void checkGrid(Scanner output, String current)
    {
        String[] coordStr = new String[2];
        try {
            coordStr = current.replace("(","").replace(")","").split(", ");
        } catch (NumberFormatException e)
        {
            fail("Your coordinates should be formatted like this: (x, y)");
        }
        int[] coord = new int[]{Integer.parseInt(coordStr[0])
                , Integer.parseInt(coordStr[1])};
        for(int i = 0; i < GRID_I; i++)
        {
            checkGrid2(output, coord, i);
        }
    }
}
