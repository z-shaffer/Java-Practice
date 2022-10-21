/* JUnit testing needs these. */
import static org.junit.Assert.fail;
import org.junit.Before;
import org.junit.Test;
import java.lang.reflect.Method;

/**
 * The test class CupcakeRecipeDeclTest.
 *
 * @author  Brooke Tibbett
 * @version 8/28/20
 */

public class WordGameDeclTest
{
    // modifier bitfields: public is 0x01, static is 0x08, final is 0x10
    private static final int PUBLIC_STATIC_MODBITS = 0x09; 
    private static final int PUBLIC_STATIC_FINAL_MODBITS = 0x19; 

    private static final String CLASS_TO_TEST = "WordGame";

    private Class c = null;

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        try
        {
            c = Class.forName(CLASS_TO_TEST);
        }
        catch (Exception e) 
        {
            c = null;
        }
    }

    /**
     * Test the expected method declarations.  
     * 
     * We are only interested in the main method for now.
     */
    @Test
    public void testMethodDeclarations()
    {
        if (c == null)           
        {
            fail("Unable to perform test.  Did you name the class correctly?");
        }

        Method[] methods = c.getDeclaredMethods();

        // main method
        boolean proper = false;
        int expectedMods = PUBLIC_STATIC_MODBITS;
        for (Method m : methods) 
        {
            int methodMods = m.getModifiers() & expectedMods;
            String rtnType = m.getReturnType().toString();
            Class<?>[] parmTyps = m.getParameterTypes();
            if (methodMods == expectedMods 
                && "main".equals(m.getName()) 
                && "void".equals(rtnType) 
                && parmTyps.length == 1 
                && "class [Ljava.lang.String;".equals(parmTyps[0].toString()))
            {
                proper = true;
            }
        }
        if (!proper)
        {
            fail("WordGameDeclTest: "
                + "main method missing or declared improperly.");
        }
    }
}

