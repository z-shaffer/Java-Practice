
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
    private Game g;
    private Random random;
    private PrintStream oldSystemOut;
    private InputStream oldSystemIn;
    private ByteArrayOutputStream outContent;

    public TestGame()
    {
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
        String exit = "EXIT";
        String inputString = "p1\nBard\n";
        String commandString = "";
        for (int i = 0; i < 10; i++)
        {
            commandString += String.format("%s", MoveType.values()[random.nextInt(MoveType.values().length)]);
            if(i < 9)
                commandString += "\n";
        }
        Player p1 = new Player("p1", PlayerClass.BARD, random);

        String[] comm = commandString.split("\n");
        inputString += commandString + "\n" + exit + "\n";
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
        String ol = "";
        String[] result = new String[9];
        result[0] = "Welcome! Please enter a name or EXIT";
        result[1] = "What class is your Player or EXIT?";
        result[2] = "Fighter, Rogue, Cleric, Wizard, Bard, or Barbarian?";
        result[3] = "You created a Player:";
        result[4] = "What would you like to do?";
        result[5] = "Goodbye";

        Scanner output = new Scanner(outContent.toString());
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: No output?");
        }
        checkLine(output, "Welcome and Name Prompt", result[0]);

        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Prompt for Player Class");
        }
        checkLine(output, "Player Class Prompt Line", result[1]);

        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Available Classes Line");
        }
        checkLine(output, "Available Classes Line", result[2]);

        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Player Created Confirmation");
        }
        checkLine(output, "Player Created Line", result[3]);

        if (!output.hasNextLine())
        {
            fail("Test for Game Failed: Player Information");
        }
        ol = output.nextLine();
        if(!repl(ol).equals(repl(p1.toString())))
        {
            fail(" Player Information Line is malformed.\n"
                + "Expected:  " + repl(p1.toString()) + "\n" 
                + "Your code: " + ol + "\n");
        }

        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Prompt for Moves");
        }
        checkLine(output, "Move Prompt Line", result[4]);

        for(int i = 0; i < 4; i++)
        {
            checkLine(output, "Move Output Line" + (i + 1),
                p1.moveList().split("\n")[i]);
        }

        for(int i = 0; i < comm.length; i++)
        {
            if(i > 0)
            {
                if (!output.hasNextLine()) 
                {
                    fail("Test for Game Failed: Prompt for Moves");
                }
                checkLine(output, "Move Prompt Line", result[4]);

                for(int j = 0; j < 4; j++)
                {
                    checkLine(output, "Move Output Line" + (j + 1),
                        p1.moveList().split("\n")[j]);
                }
            }

            if (!output.hasNextLine()) 
            {
                fail("Test for Game Failed: Move " + comm[i]);
            }
            ol = output.nextLine();
            switch(comm[i])
            {
                case "BASICATTACK":
                case "RANGEDATTACK":
                    if(!ol.equals("Hit") && !ol.equals("Miss"))
                        fail(" Move Result Line " + comm[i] + " is malformed.\n"
                            + "Expected:  Hit or Miss\n" 
                            + "Your code: " + ol + "\n");
                    break;
                case "DEFEND":
                    if(!ol.equals("Defended") && !ol.equals("Failed to Defend"))
                        fail(" Move Result Line " + comm[i] + " is malformed.\n"
                            + "Expected:  Defended or Failed to Defend\n" 
                            + "Your code: " + ol + "\n");
                    break;
                case "MOVE":
                    if(!repl(ol).equals("Moved # spaces"))
                        fail(" Move Result Line " + comm[i] + " is malformed.\n"
                            + "Expected:  Moved # spaces\n" 
                            + "Your code: " + ol + "\n");
                    break;
            }

            if (ol.equals("Failed to Defend"))
            {
                if (!output.hasNextLine()) 
                {
                    fail("Test for Game Failed: Take Damage Line");
                }
                ol = output.nextLine();
                if(!repl(ol).equals("You took # damage."))
                {
                    fail(" Take Damage Line is malformed.\n"
                        + "Expected:  You took # damage.\n" 
                        + "Your code: " + ol + "\n");
                }
            }

            if (!output.hasNextLine()) 
            {
                fail("Test for Game Failed: Heal Line");
            }
            ol = output.nextLine();
            if(!repl(ol).equals("You healed for # health."))
            {
                fail(" Heal Line is malformed.\n"
                    + "Expected:  You healed for # health.\n" 
                    + "Your code: " + ol + "\n");
            }

            if (!output.hasNextLine())
            {
                fail("Test for Game Failed: Player Information");
            }
            ol = output.nextLine();
            if(!repl(ol).equals(repl(p1.toString())))
            {
                fail(" Player Information Line is malformed.\n"
                    + "Expected:  " + repl(p1.toString()) + "\n" 
                    + "Your code: " + ol + "\n");
            }
        }
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Prompt for Moves");
        }
        checkLine(output, "Move Prompt Line", result[4]);

        for(int j = 0; j < 4; j++)
        {
            checkLine(output, "Move Output Line" + (j + 1),
                p1.moveList().split("\n")[j]);
        }
        
        if (!output.hasNextLine()) 
        {
            fail("Test for Game Failed: Missing Goodbye Line");
        }
        checkLine(output, "Goodbye Line", result[5]);
    }

    private String repl(String s)
    {
        return s.replace("0","#").replace("1","#").replace("2","#")
        .replace("3","#").replace("4","#").replace("5","#")
        .replace("6","#").replace("7","#").replace("8","#")
        .replace("9","#");
    }

    private void checkLine(Scanner output, String msg, String expected)
    {
        if (!output.hasNextLine()) 
        {
            fail("Missing " + msg);
        }
        String line = output.nextLine();
        if(!line.equals(expected))
        {
            fail(" " + msg + " is malformed.\n"
                + "Expected:  \"" + expected + "\"\n" 
                + "Your code: \"" + line + "\"\n");
        }
    }
}
