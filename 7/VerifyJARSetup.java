 

import static org.junit.Assert.fail;
import org.junit.Test;

/**
 * Tests that the PatternWorks JAR file is available.
 *  
 * @author Julia Dana
 * @version 2014-04-7
 */
public class VerifyJARSetup
{
    /**
     * Check that the classes needed from the PatternWorks jar are available.
     */
    @Test
    public void testClassesAreAvailable()
    {
        try
        {
            Class.forName("Square");
            Class.forName("Canvas");
        }
        catch (ClassNotFoundException e)
        {
            fail("Could not find classes from the PatternWorks library. \n"
                  + "Make sure the JAR file is loaded correctly.\n"
                  + "Make sure you have reset the virtual machine"
                  + " since loading the JAR\n");
        }
    }
}
