/**
 * BaseCookieTest
 *
 * We inherit from Cookie, but are only responsible for our concrete methods.
 */

// Stuff to redirect System.out for testing purposes.
import java.lang.IllegalArgumentException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

// Stuff needed for JUnit testing.
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class BaseCookieTest {

    @Test
    public void testConstructor() {
	// Surround in a try/catch to make sure it works okay or not!
	try {
	    SugarCookie yum = new SugarCookie();
	    GingerbreadCookie gb = new GingerbreadCookie();
	    
	    // if we make it here then we assume the constructor worked.
	    // And since the concrete constructor calls the superclass
	    //   constructor, then that must also have worked!!
	    // Let's just make sure it's not null, which would be bad...
	    assertNotNull(yum);
	    assertNotNull(gb);
	}
	catch (Exception e) {
	    // Should NOT get here, if so then test probably should fail.
	    fail("Constructor threw exception: " + e.getMessage());
	}
    }

    @Test
    public void testDescription() {
	// 1. Prep for test
	// 1a. Make object that has method needing testing.
	Cookie yum = new SugarCookie();
	Cookie gb = new GingerbreadCookie();

	// 1b. Declare actual and expected outputs
	String expectedResult = "Sugar";
	String testOutput = null;

	// 2. Conduct test of method 
	testOutput = yum.getDescription();

	// 3b. Check results
	//      (Can't compare String object NAMES, need to compare chars!!)
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Gingerbread";
	testOutput = gb.getDescription();

	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult
		   + "' but got '" + testOutput + "'.");
    }

    @Test
    public void testCalories() {
	// 1. Prep for test
	// 1a. Make object that has method needing testing.
	Cookie yum = new SugarCookie();
	Cookie gb = new GingerbreadCookie();

	// 1b. Declare actual and expected outputs
	int expectedResult = 315;
	int testOutput = 0;

	// 2. Conduct test of method 
	testOutput = yum.calories();

	// 3b. Check results
	//      (Can't compare String object NAMES, need to compare chars!!)
	assertEquals(expectedResult, testOutput, 
		     "Expected: " + expectedResult 
		     + ", but got: " + testOutput);

	testOutput = gb.calories();
	
	assertEquals(expectedResult, testOutput, 
		     "Expected: " + expectedResult
		     + ", but got: " + testOutput);
    }

    @Test
    public void testCost() {
	// 1. Prep for test
	// 1a. Make object that has method needing testing.
	Cookie yum = new SugarCookie();
	Cookie gb = new GingerbreadCookie();

	// 1b. Declare actual and expected outputs
	double expectedResult = 0.50;
	double testOutput = 0;

	// 2. Conduct test of method 
	testOutput = yum.cost();

	// 3b. Check results
	//      (Can't compare String object NAMES, need to compare chars!!)
	assertEquals(expectedResult, testOutput, 
		     "Expected: " + expectedResult 
		     + ", but got: " + testOutput);

	testOutput = gb.cost();
	assertEquals(expectedResult, testOutput,
		     "Expected: " + expectedResult
		     + ", but got: " + testOutput);
    }

    @Test
    public void testToString() {
	// 1. Prep for test
	// 1a. Make object that has method needing testing.
	Cookie yum = new SugarCookie();
	Cookie gb = new GingerbreadCookie();

	// 1b. Declare actual and expected outputs
	String expectedResult = "[Sugar,315,$ 0.5]";
	String testOutput = null;

	// 1c. Save current System.out and set to new stream we can read.
	PrintStream origOut = System.out;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream newOut = new PrintStream(baos);
	System.setOut(newOut);

	// 2. Conduct method test (print/println call toString automatically)
	System.out.print(yum);

	// 3. Test Cleanup
	// 3a.Get all the stuff the method wrote to System.out, and reset it.
	System.out.flush();
	testOutput = baos.toString();
	System.setOut(origOut);

	// 3b. Check results
	//      (Can't compare String object NAMES, need to compare chars!!)
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[Gingerbread,315,$ 0.5]";
	baos = new ByteArrayOutputStream();
	newOut = new PrintStream(baos);
	System.setOut(newOut);
	System.out.print(gb);
	System.out.flush();
	testOutput = baos.toString();
	System.setOut(origOut);

	assertTrue(expectedResult.equals(testOutput),
		   "Expected :'" + expectedResult
		   + "' but got '" + testOutput + "'.");
    }
}
