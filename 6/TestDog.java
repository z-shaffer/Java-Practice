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
public class TestDog
{
    private Dog d;
    private Random random;

    public TestDog()
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
        d = new Dog();
        checkName();
        checkAge();
        checkBreed();
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
    @Test
    public void checkArgConstructor()
    {
        boolean error = false;
        String fb = "";
        fb += "Constructor test failed.\n";

        d = new Dog("Cisco", 5, "Corgi");
        if (!(d.getName().equals("Cisco")))
        {
            fb += "Method getName did not return correct name" 
                + "(constrcutor issue).\n";
            error = true;
        }
        else if (d.getAge() != 5)
        {
            fb += "Method getAge did not return correct age" 
                + "(constructor issue).\n";
            error = true;
        }
        else if (!(d.getBreed().equals("Corgi")))
        {
            fb += "Method getBreed did not return correct breed"    
                + "(constructor issue).\n";
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
     * Test constructor with one set of data.
     */
    @Test
    public void checkNoArgConstructor()
    {
        boolean error = false;
        String fb = "";
        fb += "No-Arg Constructor test failed.\n";

        d = new Dog();
        if (!(d.getName().equals("")))
        {
            fb += "Method getName did not return empty String" 
                + "(constrcutor issue).\n";
            error = true;
        }
        else if (d.getAge() != 0)
        {
            fb += "Method getAge did not return 0" 
                + "(constructor issue).\n";
            error = true;
        }
        else if (!(d.getBreed().equals("")))
        {
            fb += "Method getBreed did not return empty String"    
                + "(constructor issue).\n";
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
        d.setName(randomName);
        if (!d.getName().equals(randomName))
        {
            failAM1Message("Name");
        }   
    }
    
        /**
     * Test the name accessor and mutator.
     */
    public void checkBreed()
    {
        String randomName = makeRandomAlphaString();
        if(randomName.length() > 37)
        {
            randomName = randomName.substring(0, 30);
        }
        d.setBreed(randomName);
        if (!d.getBreed().equals(randomName))
        {
            failAM1Message("Breed");
        }   
    }

    /**
     * Test the gallonsOfWater accessor and mutator for activity 1.
     */
    public void checkAge()
    {
        int randomAge = random.nextInt(20);
        d.setAge(randomAge);
        if (d.getAge() != randomAge)
        {
            failAM1Message("Age");
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
    
    /**
     * First test of the sellLemonade method 
     * for activity 1.
     */
    @Test
    public void checkIncreaseAge()
    {
        String fb = "";
        String randomName = makeRandomAlphaString();
        if(randomName.length() > 37)
        {
            randomName = randomName.substring(0, 37);
        }
        int randomAge = random.nextInt(20);
        String randomBreed = makeRandomAlphaString();
        if(randomBreed.length() > 37)
        {
            randomBreed = randomBreed.substring(0, 37);
        }
        d = new Dog(randomName, randomAge, randomBreed);
        d.increaseAge();
        int newAge = d.getAge();

        fb += "Test for increase age failed.\n";  

        if (newAge != randomAge + 1)
        {
            fb += "Expected age (after call to increaseAge): " 
                + (randomAge + 1);
            fb += "Your code gave: " 
                + newAge + ".\n";
            fail(fb);
        }
    }
    
        /**
     * First test of the sellLemonade method 
     * for activity 1.
     */
    @Test
    public void checkBark()
    {
        String fb = "";
        d = new Dog();

        fb += "Test for bark failed.\n";  

        if (!d.bark().equals("bark!"))
        {
            fb += "bark failed to produce \"bark!\"";
            fail(fb);
        }
    }
    
            /**
     * First test of the sellLemonade method 
     * for activity 1.
     */
    @Test
    public void checkBarkParam()
    {
        String fb = "";
        d = new Dog();
        String randomName = makeRandomAlphaString();
        if(randomName.length() > 37)
        {
            randomName = randomName.substring(0, 37);
        }
        fb += "Test for bark failed.\n";  

        if (!d.bark(randomName).equals("barking at " + randomName + "!"))
        {
            fb += "bark failed to produce \"barking at _______!\"";
            fail(fb);
        }
    }
    
        /**
     * First test of the sellLemonade method 
     * for activity 1.
     */
    @Test
    public void checkEquals()
    {
        String fb = "";
        String randomName = makeRandomAlphaString();
        if(randomName.length() > 37)
        {
            randomName = randomName.substring(0, 37);
        }
        int randomAge = random.nextInt(20);
        String randomBreed = makeRandomAlphaString();
        if(randomBreed.length() > 37)
        {
            randomBreed = randomBreed.substring(0, 37);
        }
        d = new Dog(randomName, randomAge, randomBreed);
        
        randomName = makeRandomAlphaString();
        if(randomName.length() > 37)
        {
            randomName = randomName.substring(0, 37);
        }
        Dog d2 = new Dog(randomName, randomAge, randomBreed);
        
        boolean eq = d.equals(d2);

        fb += "Test for equals failed.\n";  

        if (eq)
        {
            fb += "Equals returned true when two dog objects were not equal";
            fail(fb);
        }
    }
    
            /**
     * First test of the sellLemonade method 
     * for activity 1.
     */
    @Test
    public void checkNotEquals()
    {
        String fb = "";
        String randomName = makeRandomAlphaString();
        if(randomName.length() > 37)
        {
            randomName = randomName.substring(0, 37);
        }
        int randomAge = random.nextInt(20);
        String randomBreed = makeRandomAlphaString();
        if(randomBreed.length() > 37)
        {
            randomBreed = randomBreed.substring(0, 37);
        }
        d = new Dog(randomName, randomAge, randomBreed);
        Dog d2 = new Dog(randomName, randomAge, randomBreed);
        
        boolean eq = d.equals(d2);

        fb += "Test for equals failed.\n";  

        if (!eq)
        {
            fb += "Equals returned false when two dog objects were equal";
            fail(fb);
        }
    }
    
        
            /**
     * First test of the sellLemonade method 
     * for activity 1.
     */
    @Test
    public void checktoString()
    {
        String fb = "";
        String randomName = makeRandomAlphaString();
        if(randomName.length() > 37)
        {
            randomName = randomName.substring(0, 37);
        }
        int randomAge = random.nextInt(20);
        String randomBreed = makeRandomAlphaString();
        if(randomBreed.length() > 37)
        {
            randomBreed = randomBreed.substring(0, 37);
        }
        d = new Dog(randomName, randomAge, randomBreed);
        
        String res = d.toString();

        fb += "Test for toString failed.\n";  

        if (!res.equals("name: " + randomName + "\nage: " + randomAge
                + "\nbreed: " + randomBreed))
        {
            fb += "Equals returned false when two dog objects were equal";
            fail(fb);
        }
    }
}
