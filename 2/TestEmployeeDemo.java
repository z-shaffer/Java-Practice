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
public class TestEmployeeDemo
{
    private EmployeeDemo e;
    private Random random;
    private PrintStream oldSystemOut;
    private InputStream oldSystemIn;
    private ByteArrayOutputStream outContent;
    
    public TestEmployeeDemo()
    {
        e = null;
        oldSystemOut = null;
        oldSystemIn = null;
        random = new Random(System.currentTimeMillis()); 
        e = new EmployeeDemo();
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
    public void checkPrintInfo()
    {        
        String randomName = makeRandomAlphaString();
        if(randomName.length() > 37)
        {
            randomName = randomName.substring(0, 37);
        }
        
        int randomId = random.nextInt(10000);
        double randomPay = (5 + random.nextInt(15)) * random.nextDouble();
        
        String inputString = randomName + "\n" 
                                + randomId + "\n" 
                                + randomPay + "\n";
                                
        ByteArrayInputStream inContent = 
                new ByteArrayInputStream(inputString.getBytes());

        System.setIn(inContent);

        // input is set, call the student's method!
        try 
        {
            e.main(null);
        }
        catch (java.util.InputMismatchException e) 
        {
            e.printStackTrace();
            fail("In main, input did not match what your Scanner expected." 
                + "Read data in order of description in assignment.");
        }
        catch (java.util.NoSuchElementException e) 
        {
            e.printStackTrace();
            fail("In main, your Scanner expected more input than provided." 
                + "Assignment specified 3 input values.");
        }
        catch (java.lang.IllegalStateException e) 
        {
            e.printStackTrace();
            fail("In main, your Scanner malfunctioned; " 
                + "did it get closed somehow."
                + " \nView the exception details in the bottom section"  
                + " of your terminal window.");
        }
        catch (java.util.IllegalFormatConversionException e) 
        {
            e.printStackTrace();
            fail("In main, you have an incorrect format in your printf."
                + " You seem to be trying to print a string with a d or f" 
                + " conversion."
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
        String[] result = new String[4];
        result[0] = new String("");
        result[1] = String.format("Employee Name:\t%s", randomName);
        result[2] = String.format("Employee ID:\t%d", randomId);
        result[3] = String.format("Employee Pay:\t$%.2f", randomPay);
        
        Scanner output = new Scanner(outContent.toString());
        output.nextLine();
        if (!output.hasNextLine()) 
        {
            fail("Test for PrintInfo Failed: No output?");
        }
        checkLine(output, "Name line of output", result[1]);

        if (!output.hasNextLine()) 
        {
            fail("Test for PrintInfo Failed: Missing id line of output");
        }
        checkLine(output, "Id line of output", result[2]);
        
        if (!output.hasNextLine()) 
        {
            fail("Test for PrintInfo Failed: Missing pay line of output");
        }
        checkLine(output, "Pay line of output", result[3]);
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

    /**
     * Helper method for making random data.
     * 
     * @return a random string
     */
    private String makeRandomAlphaString()
    {
        return makeRandomAlphaString(random.nextInt(100));
    }

    /**
     * Helper method for making random data.
     * 
     * @param len is the desired length of the random string
     * @return the random string generated
     */
    private String makeRandomAlphaString(int len)
    {
        final int NUM_ALPHA_CHARS = 26;
        int i;
        char[] charArray = new char[len];
        for (i = 0; i < len; i++) 
        {
            if (random.nextBoolean() == true) 
            {
                charArray[i] = (char) ('A' + random.nextInt(NUM_ALPHA_CHARS));
            }
            else
            {
                charArray[i] = (char) ('a' + random.nextInt(NUM_ALPHA_CHARS));
            }
        }

        return new String(charArray);
    }    
}
