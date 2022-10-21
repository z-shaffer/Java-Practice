// Junit testing framework.
import static org.junit.Assert.fail;  
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

// Redirecting System.in and System.out
import java.io.PrintStream;            
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.ByteArrayInputStream;

// for testing our class
import java.util.Scanner;      
import java.util.Random;

/**
 * The test class CupcakeRecipeMethodTest.
 *
 *
 * @author  Brooke Tibbett
 * @version 8/28/20
 */
public class CupcakeRecipeMethodTest
{
    private static final String FILE_TO_TEST = "CupcakeRecipeAdvisor.java";
    private static final int CUPCAKES_TOTAL = 36;
    private static final double SUGAR_CUPS = 3;
    private static final double MILK_CUPS = 1.5;
    private static final double OIL_CUPS = .75;

    private CupcakeRecipeAdvisor cupcake;
    private PrintStream oldSystemOut;
    private InputStream oldSystemIn;
    private ByteArrayOutputStream outContent;
    private Random random;
    private int randomCupcake;

    /**
     * Default constructor.
     */
    public CupcakeRecipeMethodTest()
    {
        cupcake = null;
        oldSystemOut = null;
        oldSystemIn = null;
        random = new Random(System.currentTimeMillis()); 
        cupcake = new CupcakeRecipeAdvisor();
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
     * Sets up the test fixture.
     *
     * Called before every test case method.  Sets up new I/O streams.
     * Creates test object.
     */
    @Before
    public void setUp()
    {
        oldSystemIn = System.in;
        oldSystemOut = System.out;
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
    }

    /**
     * Resets I/O streams.
     */
    private void resetStreams()
    {
        System.setOut(oldSystemOut);
        System.setIn(oldSystemIn);
    }

    /**
     * Tests the sample data from the assignment specification.
     */
    @Test
    public void testSampleData()
    {
        String inputString = "60\n";
        ByteArrayInputStream inContent = new ByteArrayInputStream(
                inputString.getBytes());
        System.setIn(inContent);

        try 
        {
            cupcake.main(null);
        }
        catch (java.util.InputMismatchException e) 
        {
            e.printStackTrace();
            fail("Input did not match what your Scanner expected." 
                + "Did you use the correct scanner method to read the number?"
                + " \nView the exception details in the bottom section"  
                + " of your terminal window.");

        }
        catch (java.util.NoSuchElementException e) 
        {
            e.printStackTrace();
            fail("Your Scanner expected more input than provided." 
                + "Assignment specified 1 input value."
                + " \nView the exception details in the bottom section"  
                + " of your terminal window.");

        }
        catch (java.lang.IllegalStateException e) 
        {
            e.printStackTrace();
            fail("Your Scanner malfunctioned; did it get closed somehow?"
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

        verifySampleOutput(outContent.toString());
    }

    /**
     * Private method to check proper format of output line.
     * 
     * @param output Scanner containing next line to check
     * @param msg is a pretty printing message
     * @param expected is the expected output
     */
    private void checkLine(Scanner output, String msg, String expected)
    {
        if (!output.hasNextLine()) 
        {
            fail("Missing " + msg);
        }
        String line = output.nextLine();
        if (!line.equals(expected))
        {
            fail(" " + msg + " isn't correct.\n"
                + "Expected:  \"" + expected + "\"\n" 
                + "Your code: \"" + line + "\"\n");
        }
    }

    /**
     * Private method to verify student output when given sample input.
     * 
     * @param outputString is the student program's actual output
     */
    public void verifySampleOutput(String outputString) 
    {
        String expectedOutput[] = 
        { 
            "To make 60 cupcakes, you will need:",
            "\t5.0 cups of sugar",
            "\t2.5 cups of milk",
            "\t1.25 cups of vegetable oil"
        };

        Scanner output = new Scanner(outputString);

        /* check line 1 */
        if (!output.hasNextLine()) 
        {
            fail("No Output?");
        }
        output.nextLine();

        if (!output.hasNextLine()) 
        {
            fail("No Output?");
        }
        checkLine(output, "Line 1 Problem", expectedOutput[0]);

        /* check line 2 */
        if (!output.hasNextLine()) 
        {
            fail("Missing Line 2");
        }
        checkLine(output, "Line 2 Problem", expectedOutput[1]);

        if (!output.hasNextLine()) 
        {
            fail("Missing Line 3");
        }
        checkLine(output, "Line 3 Problem", expectedOutput[2]);

        if (!output.hasNextLine()) 
        {
            fail("Missing Line 4");
        }
        checkLine(output, "Line 4 Problem", expectedOutput[3]);
    }

    /**
     * Helper method to generate random data and store in fields.
     */
    private void generateInputData()
    {
        final int MAX_CUPCAKES = 1000;

        randomCupcake = random.nextInt(MAX_CUPCAKES);
    }

    /**
     * Tests student code using random input data.
     */
    @Test
    public void testRandomData()
    {
        generateInputData();

        // build inupt string from the random data and put into input stream
        String inputString = randomCupcake + "\n";
        ByteArrayInputStream inContent = 
            new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inContent);

        // input is set, call the student's method!
        try 
        {
            cupcake.main(null);
        }
        catch (java.util.InputMismatchException e) 
        {
            e.printStackTrace();
            fail("Input did not match what your Scanner expected." 
                + "Did you use the correct scanner method to read the number?"
                + " \nView the exception details in the bottom section"  
                + " of your terminal window.");

        }
        catch (java.util.NoSuchElementException e) 
        {
            e.printStackTrace();
            fail("Your Scanner expected more input than provided." 
                + "Assignment specified 1 input value."
                + " \nView the exception details in the bottom section"  
                + " of your terminal window.");

        }
        catch (java.lang.IllegalStateException e) 
        {
            e.printStackTrace();
            fail("Your Scanner malfunctioned; did it get closed somehow?"
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
        verifyRandomOutput(outContent.toString());
    }

    /**
     * Helper method to build expected output from the random data fields.
     * 
     * @return String array of expected output based on random data in fields
     */
    private String[] buildExpectedOutput()
    {
        String output[] = new String[5];

        /* line of underscores */
        output[0] = new String("");

        output[1] = String.format("To make %d cupcakes, you will need:",
                    randomCupcake);

        double sugar = (SUGAR_CUPS / CUPCAKES_TOTAL) * randomCupcake;
        double milk = (MILK_CUPS / CUPCAKES_TOTAL) * randomCupcake;
        double oil = (OIL_CUPS / CUPCAKES_TOTAL) * randomCupcake;

        output[2] = "\t" + sugar + " cups of sugar";
        output[3] = "\t" + milk + " cups of milk";
        output[4] = "\t" + oil + " cups of vegetable oil";

        return output;
    }

    /**
     * Helper method to verify output is expected.
     * 
     * @param outputString is the student's output
     */
    private void verifyRandomOutput(String outputString) 
    {
        String expectedOutput[] = buildExpectedOutput();
        Scanner output = new Scanner(outputString);

        /* check line 1 */
        if (!output.hasNextLine()) 
        {
            fail("No Output?");
        }
        output.nextLine();

        if (!output.hasNextLine()) 
        {
            fail("No Output?");
        }
        checkLine(output, "Line 1 Problem", expectedOutput[1]);

        /* check line 2 */
        if (!output.hasNextLine()) 
        {
            fail("Missing Line 2");
        }
        checkLine(output, "Line 2 Problem", expectedOutput[2]);

        if (!output.hasNextLine()) 
        {
            fail("Missing Line 3");
        }
        checkLine(output, "Line 3 Problem", expectedOutput[3]);

        if (!output.hasNextLine()) 
        {
            fail("Missing Line 4");
        }
        checkLine(output, "Line 4 Problem", expectedOutput[4]);
    }
}

