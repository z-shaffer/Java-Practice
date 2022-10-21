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
 * The test class WordGameMethodTest.
 *
 *
 * @author  Brooke Tibbett
 * @version 8/29/20
 */
public class WordGameMethodTest
{
    private static final String FILE_TO_TEST = "WordGame.java";

    private WordGame word;
    private PrintStream oldSystemOut;
    private InputStream oldSystemIn;
    private ByteArrayOutputStream outContent;
    private String randomName;
    private int randomAge;
    private String randomCollege;
    private String randomProfession;
    private String randomAnimal;
    private String randomPetName;
    private String randomCity;
    private Random random;
    
    /**
     * Default constructor.
     */
    public WordGameMethodTest()
    {
        word = null;
        oldSystemOut = null;
        oldSystemIn = null;
        random = new Random(System.currentTimeMillis()); 
        word = new WordGame();
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
        String inputString = "Jane Romero\nTalk Show Host\nNorthwestern\n"
            + "Cat\nAdiris\n32";
        ByteArrayInputStream inContent = new ByteArrayInputStream(
                inputString.getBytes());
        System.setIn(inContent);

        try 
        {
            word.main(null);
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
            fail(" " + msg + " is malformed.\n"
                + "Expected:  \"" + expected + "\"\n" 
                + "Your code: \"" + line + "\"\n");
        }
    }

    /**
     * Private method to verify student output when given sample input.
     * 
     * @param outputString is the student program's actual output
     */
    private void verifySampleOutput(String outputString) 
    {
        String expectedOutput[] = 
        { 
            "",
            "This is the story of JANE ROMERO.",
            "JANE ROMERO was determined to become a TALK SHOW HOST.",
            "So they went to college at NORTHWESTERN.",
            "JANE ROMERO worked really hard and achieved their dream at the age of 32!",
            "JANE ROMERO decided to adopt a(n) CAT named ADIRIS.",
            "JANE ROMERO and ADIRIS both lived happily ever after or did they?"

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

        if (!output.hasNextLine()) 
        {
            fail("Missing Line 5");
        }
        checkLine(output, "Line 5 Problem", expectedOutput[5]);
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

    /**
     * Helper method to generate random data and store in fields.
     */
    private void generateInputData()
    {
        final int NAME_FIELD_SIZE = 30;
        final int MAX_AGE = 90;

        randomName = makeRandomAlphaString();
        if (randomName.length() > NAME_FIELD_SIZE) 
        {
            randomName = randomName.substring(0, NAME_FIELD_SIZE);
        }

        randomCollege = makeRandomAlphaString();
        if (randomCollege.length() > NAME_FIELD_SIZE) 
        {
            randomCollege = randomCollege.substring(0, NAME_FIELD_SIZE);
        }

        randomProfession = makeRandomAlphaString();
        if (randomProfession.length() > NAME_FIELD_SIZE) 
        {
            randomProfession = randomProfession.substring(0, NAME_FIELD_SIZE);
        }

        randomAnimal = makeRandomAlphaString();
        if (randomAnimal.length() > NAME_FIELD_SIZE) 
        {
            randomAnimal = randomAnimal.substring(0, NAME_FIELD_SIZE);
        }

        randomPetName = makeRandomAlphaString();
        if (randomPetName.length() > NAME_FIELD_SIZE) 
        {
            randomPetName = randomPetName.substring(0, NAME_FIELD_SIZE);
        }

        randomAge = random.nextInt(MAX_AGE);
    }

    /**
     * Tests student code using random input data.
     */
    @Test
    public void testRandomData()
    {
        generateInputData();

        // build inupt string from the random data and put into input stream
        String inputString = randomName + "\n" 
            + randomProfession + "\n" 
            + randomCollege + "\n" 
            + randomAnimal + "\n"  
            + randomPetName + "\n"
            + randomAge + "\n";
        ByteArrayInputStream inContent = 
            new ByteArrayInputStream(inputString.getBytes());
        System.setIn(inContent);

        // input is set, call the student's method!
        try 
        {
            word.main(null);
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
        String output[] = new String[10];

        output[0] = new String("");

        output[1] = "This is the story of " + randomName.toUpperCase()
            + ".";
        output[2] = randomName.toUpperCase() + " was determined to "
            + "become a " + randomProfession.toUpperCase()+ ".";
        output[3] = "So they went to college at " 
            + randomCollege.toUpperCase() + ".";
        output[4] = randomName.toUpperCase() + " worked really hard and "
            + "achieved their dream at the age of " + randomAge + "!";
        output[5] = randomName.toUpperCase() + " decided to adopt a(n) "
            + randomAnimal.toUpperCase() + " named " 
            + randomPetName.toUpperCase() + ".";
        output[6] = randomName.toUpperCase() + " and " 
            + randomPetName.toUpperCase() + " both lived happily ever "
            + "after or did they?";

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

        if (!output.hasNextLine()) 
        {
            fail("Missing Line 5");
        }
        checkLine(output, "Line 5 Problem", expectedOutput[5]);

    }
}

