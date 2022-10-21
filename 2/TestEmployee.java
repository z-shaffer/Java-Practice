import static org.junit.Assert.fail;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Random;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;
/**
 * Tests employee class
 *
 * @author Joel Swanson - modified Brooke Tibbett
 * @version 02.07.2014 - modified 9/3/2020
 */
public class TestEmployee
{
    private Employee e;
    private Random random;

    public TestEmployee()
    {
        random = new Random(System.currentTimeMillis());
    }

    /**
     * Simple test of accessors and mutators.  Do they 
     * correctly set values.
     */
    @Test
    public void testAccessorsMutators()
    {
        e = new Employee("test", 534, 6.00);
        checkName();
        checkId();
        checkPay();
    }

    /**
     * Test the argument constructor.
     */
    @Test  
    public void testConstructor()
    {
        checkCA();
    }

    /**
     * First test of the sellLemonade method 
     * for activity 1.
     */
    @Test
    public void checkGiveRaise()
    {
        String fb = "";
        double randomPay = (5 + random.nextInt(15)) * random.nextDouble();
        double randomRaise = random.nextInt(5) * random.nextDouble();
        e = new Employee("Tester", 1235324, randomPay);
        e.giveRaise(randomRaise);
        double pay = e.getPay();

        fb += "Test for GiveRaise failed.\n";
        fb += "The following code was executed:\n";
        fb += "\t Employee e = new Employee(\"Tester\"," 
            + " 1235324, A Random Number);\n";
        fb += "\t e.giveRaise(A Random Number);\n";    

        if (pay != randomPay + randomRaise)
        {
            fb += "Expected pay (after call to giveRaise): " 
                + (randomPay + randomRaise);
            fb += "Your code gave: " 
                + pay + ".\n";
            fb += "Make sure to add the parameter to pay" 
                + ".\n";
            fail(fb);
        }
    }

    @Test
    public void checkPrintInfo()
    {
        PrintStream oldSystemOut = System.out;
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        
        String randomName = makeRandomAlphaString();
        if(randomName.length() > 37)
        {
            randomName = randomName.substring(0, 37);
        }
        
        int randomId = random.nextInt(10000);
        double randomPay = (5 + random.nextInt(15)) * random.nextDouble();
        
        e = new Employee(randomName, randomId, randomPay);
        e.printInfo();
        
        String[] result = new String[3];
        result[0] = String.format("Employee Name:\t%s", randomName);
        result[1] = String.format("Employee ID:\t%d", randomId);
        result[2] = String.format("Employee Pay:\t$%.2f", randomPay);
        
        Scanner output = new Scanner(outContent.toString());

        if (!output.hasNextLine()) 
        {
            fail("Test for PrintInfo Failed: No output?");
        }
        checkLine(output, "Name line of output", result[0]);

        if (!output.hasNextLine()) 
        {
            fail("Test for PrintInfo Failed: Missing id line of output");
        }
        checkLine(output, "Id line of output", result[1]);
        
        if (!output.hasNextLine()) 
        {
            fail("Test for PrintInfo Failed: Missing pay line of output");
        }
        checkLine(output, "Pay line of output", result[2]);
        
        System.setOut(oldSystemOut);
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
     * Test constructor with one set of data.
     */
    public void checkCA()
    {
        boolean error = false;
        String fb = "";
        fb += "Constructor test failed.\n";
        fb += "An was created like this:\n\n";
        fb += "\te = new Employee(\"Claudette Morel\", 1234, 20.00)\n\n";

        e = new Employee("Claudette Morel", 1234, 20.00);
        if (e.getName() != "Claudette Morel")
        {
            fb += "Method getName did not return Claudette Morel.\n";
            error = true;
        }
        else if (e.getId() != 1234)
        {
            fb += "Method getId did not return 1234.\n";
            error = true;
        }
        else if (e.getPay() != 20.00)
        {
            fb += "Method getPay did not return 20.00.\n";
            error = true;
        }

        fb += "Correct any accessor or mutator problem first.\n";
        fb += "Make sure parameter order for constructor is exactly\n";
        fb += "the same as the order defined in the UML diagram.\n";

        if (error)
        {
            fail(fb);
        }
    }

    /**
     * Test the name accessor and mutator.
     */
    public void checkName()
    {
        String randomName = makeRandomAlphaString();
        if(randomName.length() > 37)
        {
            randomName = randomName.substring(0, 30);
        }
        e.setName(randomName);
        if (!e.getName().equals(randomName))
        {
            failAM1Message("Name");
        }   
    }

    /**
     * Test the gallonsOfWater accessor and mutator for activity 1.
     */
    public void checkId()
    {
        int randomId = random.nextInt(900000) + 1;
        e.setId(randomId);
        if (e.getId() != randomId)
        {
            failAM1Message("Id");
        }
    }

    /**
     * Test the glassesOfLemonade accessor and mutator for activity 1.
     */
    public void checkPay()
    {
        double randomPay = (5 + random.nextInt(15)) * random.nextDouble();
        e.setPay(randomPay);
        if (e.getPay() != randomPay)
        {
            failAM1Message("Pay");
        }
    }       

    /**
     * Print a fail message for an accessor or mutator in
     * activity 1.
     * @param fieldName The name of the field which failed.
     */
    public void failAM1Message(String fieldName)
    {
        String fb = "";
        fb += "Accessor or mutator failed.\n";
        fb += "Either set" + fieldName + " or get" + fieldName + ".\n";
        fail(fb);
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
