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
 * @author Joel Swanson - modified Brooke Tibbett
 * @version 02.07.2014 - modified 9/3/2020
 */
public class TestGame
{
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
    public void checkUp()
    {        
        String exit = "exit";
        String inputString = "up" + "\n";       
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
            fail("Test for Up Failed: No output?");
        }
        checkLine(output, "Welcome Line", result[0]);

        if (!output.hasNextLine()) 
        {
            fail("Test for Up Failed: Missing Acceptable Commands");
        }
        checkLine(output, "Acceptable Commands Line", result[1]);
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Up Failed: Missing Next Move? Line");
        }
        checkLine(output, "Next Move Line", result[2]);
        String curr = "(0, 0)";
        String coord = "";
        coord = processCommand("up", curr);
        if (!output.hasNextLine()) 
        {
            fail("Test for Up Failed: Didn't show output after command.");
        }
        checkLine(output, "Next Move Line After Up Command", result[3].replace("$$", coord));
        curr = coord;
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Goodbye Line");
        }
        checkLine(output, "Goodbye Line", result[4].replace("$$", coord));
    }
    
    @Test
    public void checkDown()
    {        
        String exit = "exit";
        String inputString = "down" + "\n";       
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
            fail("Test for Down Failed: No output?");
        }
        checkLine(output, "Welcome Line", result[0]);

        if (!output.hasNextLine()) 
        {
            fail("Test for Down Failed: Missing Acceptable Commands");
        }
        checkLine(output, "Acceptable Commands Line", result[1]);
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Down Failed: Missing Next Move? Line");
        }
        checkLine(output, "Next Move Line", result[2]);
        String curr = "(0, 0)";
        String coord = "";
        coord = processCommand("down", curr);
        if (!output.hasNextLine()) 
        {
            fail("Test for Down Failed: Didn't show output after command.");
        }
        checkLine(output, "Next Move Line After Down Command", result[3].replace("$$", coord));
        curr = coord;
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Goodbye Line");
        }
        checkLine(output, "Goodbye Line", result[4].replace("$$", coord));
    }
    
    @Test
    public void checkRight()
    {        
        String exit = "exit";
        String inputString = "right" + "\n";       
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
            fail("Test for Right Failed: No output?");
        }
        checkLine(output, "Welcome Line", result[0]);

        if (!output.hasNextLine()) 
        {
            fail("Test for Right Failed: Missing Acceptable Commands");
        }
        checkLine(output, "Acceptable Commands Line", result[1]);
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Right Failed: Missing Next Move? Line");
        }
        checkLine(output, "Next Move Line", result[2]);
        String curr = "(0, 0)";
        String coord = "";
        coord = processCommand("right", curr);
        if (!output.hasNextLine()) 
        {
            fail("Test for Right Failed: Didn't show output after command.");
        }
        checkLine(output, "Next Move Line After Right Command", result[3].replace("$$", coord));
        curr = coord;
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Goodbye Line");
        }
        checkLine(output, "Goodbye Line", result[4].replace("$$", coord));
    }
    
    @Test
    public void checkLeft()
    {        
        String exit = "exit";
        String inputString = "left" + "\n";       
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
            fail("Test for Left Failed: No output?");
        }
        checkLine(output, "Welcome Line", result[0]);

        if (!output.hasNextLine()) 
        {
            fail("Test for Left Failed: Missing Acceptable Commands");
        }
        checkLine(output, "Acceptable Commands Line", result[1]);
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Left Failed: Missing Next Move? Line");
        }
        checkLine(output, "Next Move Line", result[2]);
        String curr = "(0, 0)";
        String coord = "";
        coord = processCommand("left", curr);
        if (!output.hasNextLine()) 
        {
            fail("Test for Left Failed: Didn't show output after command.");
        }
        checkLine(output, "Next Move Line After Left Command", result[3].replace("$$", coord));
        curr = coord;
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Goodbye Line");
        }
        checkLine(output, "Goodbye Line", result[4].replace("$$", coord));
    }
    
    @Test
    public void checkInput()
    {        
        String exit = "exit";
        String inputString = "";

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
        }
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Goodbye Line");
        }
        checkLine(output, "Goodbye Line", result[4].replace("$$", coord));
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
            return String.format("(%d, %d)", coord[0], coord[1] + 1);
        }
        else if(c.toUpperCase().equals("DOWN"))
        {
            return String.format("(%d, %d)", coord[0], coord[1] - 1);
        }
        else if(c.toUpperCase().equals("RIGHT"))
        {
            return String.format("(%d, %d)", coord[0] + 1, coord[1]);
        }
        else if(c.toUpperCase().equals("LEFT"))
        {
            return String.format("(%d, %d)", coord[0] - 1, coord[1]);
        }
        return "";
    }
}
