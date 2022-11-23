/**
 * CookieTest
 *
 * Cookie is an abstract class, and recall that you can NOT instantiate
 * an object from an abstract class. So then, now can we test it?
 *
 * We only need to test methods that are the responsibility of the 
 * abstract class. Here, we need to test the constructor and the
 * getDescription() method. The abstract methods will be the responsibilty
 * of any subclasses.
 *
 * But again, how can we call the constructor? Java won't allow it.
 * So, we need a concrete subclass that extends this superclass. We can then
 * instantiate an object of this subclass and the only purpose for this
 * object (and its class actually) is to allow us to invoke the constructor
 * and getDescription() method defined in its abstract superclass.
 * So, the implementations of the abstract methods is required but we are
 * not interested in them here so we just make them degenerate.
 *
 * So I will declare and define a transient Cookie subclass just for our
 * testing. Let's call it: XxxxCookie.
 */

// Stuff to redirect System.out for testing purposes.
import java.lang.IllegalArgumentException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

// Stuff needed for JUnit testing.
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class XxxxCookie extends Cookie {
    // Concrete constructor calls superclass constructor
    public XxxxCookie() {
	super("XxxxCookie for testing only!",0,0);
    }
    // We inherit the getDescription method
    // But we need to implement in some form or fashion the abstract methods.
    public int calories() { return 0; }
    public double cost() { return 0.0; }
    public String toString() { return "Empty XxxxCookie test object"; }
}

public class CookieTest {

    @Test
    public void testConstructor() {
	// We can't create object of abstract class.
	// We have to create object of concrete subclass.
	// We made our own XxxxCookie subclass, right here in this file!
	// So we will use that now...

	// Surround in a try/catch to make sure it works okay or not!
	try {
	    Cookie xxxxCookie = new XxxxCookie();
	    
	    // if we make it here then we assume the constructor worked.
	    // And since the concrete constructor calls the superclass
	    //   constructor, then that must also have worked!!
	    // Let's just make sure it's not null, which would be bad...
	    assertNotNull(xxxxCookie);
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
	Cookie xxxxCookie = new XxxxCookie();

	// 1b. Declare actual and expected outputs
	String expectedResult = "XxxxCookie for testing only!";
	String testOutput = null;

	// 2. Conduct test of method 
	testOutput = xxxxCookie.getDescription();

	// 3b. Check results
	//      (Can't compare String object NAMES, need to compare chars!!)
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
    }

    @Test
    public void testToString() {
	// 1. Prep for test
	// 1a. Make object that has method needing testing.
	Cookie xxxxCookie = new XxxxCookie();

	// 1b. Declare actual and expected outputs
	String expectedResult = "Empty XxxxCookie test object";
	String testOutput = null;

	// 1c. Save current System.out and set to new stream we can read.
	
	PrintStream origOut = System.out;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream newOut = new PrintStream(baos);
	System.setOut(newOut);

	// 2. Conduct method test (print/println call toString automatically)
	System.out.print(xxxxCookie);

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
    }

    @Test
    public void testHasNuts() {
	Cookie nutCookie = new Pecans(new SugarCookie());
	
	boolean expectedResult = true;

	assertTrue(expectedResult == nutCookie.hasNuts(),
		   "Expected:'" + expectedResult 
		   + "' but got '" + nutCookie.hasNuts() + "'.");
	}
}
