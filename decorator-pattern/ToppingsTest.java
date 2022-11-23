/**
 * ToppingsTest
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


public class ToppingsTest {

    @Test
    public void testConstructor() {
	// Surround in a try/catch to make sure it works okay or not!
	try { 
	    Cookie cookie = new SugarCookie();
	    ChocolateChips cc = new ChocolateChips(cookie);
	    Pecans pe = new Pecans(cookie);
	    PowderedSugar ps = new PowderedSugar(cookie);
	    Sprinkles sp = new Sprinkles(cookie);
	    Walnuts wa = new Walnuts(cookie);
	
	    
	    // if we make it here then we assume the constructor worked.
	    // And since the concrete constructor calls the superclass
	    //   constructor, then that must also have worked!!
	    // Let's just make sure it's not null, which would be bad...
	    assertNotNull(cc);
	    assertNotNull(pe);
	    assertNotNull(ps);
	    assertNotNull(sp);
	    assertNotNull(wa);
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
	    Cookie cookie = new SugarCookie();
	    ChocolateChips cc = new ChocolateChips(cookie);
	    Pecans pe = new Pecans(cookie);
	    PowderedSugar ps = new PowderedSugar(cookie);
	    Sprinkles sp = new Sprinkles(cookie);
	    Walnuts wa = new Walnuts(cookie);

	// 1b. Declare actual and expected outputs
	String expectedResult = "Sugar, Chocolate Chips";
	String testOutput = null;

	// 2. Conduct test of method 
	testOutput = cc.getDescription();

	// 3b. Check results
	//      (Can't compare String object NAMES, need to compare chars!!)
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Sugar, Pecans";
	testOutput = pe.getDescription();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult
		   + "' but got '" + testOutput + "'.");
	
	expectedResult = "Sugar, Powdered Sugar";
	testOutput = ps.getDescription();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult
		   + "' but got '" + testOutput + "'.");


	expectedResult = "Sugar, Sprinkles";
	testOutput = sp.getDescription();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult
		   + "' but got '" + testOutput + "'.");


	expectedResult = "Sugar, Walnuts";
	testOutput = wa.getDescription();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult
		   + "' but got '" + testOutput + "'.");
    }

    @Test
    public void testCalories() {
	// 1. Prep for test
	// 1a. Make object that has method needing testing.
	    Cookie cookie = new SugarCookie();
	    ChocolateChips cc = new ChocolateChips(cookie);
	    Pecans pe = new Pecans(cookie);
	    PowderedSugar ps = new PowderedSugar(cookie);
	    Sprinkles sp = new Sprinkles(cookie);
	    Walnuts wa = new Walnuts(cookie);

	// 1b. Declare actual and expected outputs
	int expectedResult = 495;
	int testOutput = 0;

	// 2. Conduct test of method 
	testOutput = cc.calories();

	// 3b. Check results
	//      (Can't compare String object NAMES, need to compare chars!!)
	assertEquals(expectedResult, testOutput, 
		     "Expected: " + expectedResult 
		     + ", but got: " + testOutput);
	
	expectedResult = 435;
	testOutput = pe.calories();
	
	assertEquals(expectedResult, testOutput, 
		     "Expected: " + expectedResult
		     + ", but got: " + testOutput);
	
	expectedResult = 475;
	testOutput = ps.calories();
	
	assertEquals(expectedResult, testOutput, 
		     "Expected: " + expectedResult
		     + ", but got: " + testOutput);    
	
	expectedResult = 465;
	testOutput = sp.calories();
	
	assertEquals(expectedResult, testOutput, 
		     "Expected: " + expectedResult
		     + ", but got: " + testOutput);

	
	expectedResult = 450;
	testOutput = wa.calories();
	
	assertEquals(expectedResult, testOutput, 
		     "Expected: " + expectedResult
		     + ", but got: " + testOutput);
}

    @Test
    public void testCost() {
	// 1. Prep for test
	// 1a. Make object that has method needing testing.
	    Cookie cookie = new SugarCookie();
	    ChocolateChips cc = new ChocolateChips(cookie);
	    Pecans pe = new Pecans(cookie);
	    PowderedSugar ps = new PowderedSugar(cookie);
	    Sprinkles sp = new Sprinkles(cookie);
	    Walnuts wa = new Walnuts(cookie);

	// 1b. Declare actual and expected outputs
	double expectedResult = 0.95;
	double testOutput = 0;

	// 2. Conduct test of method 
	testOutput = cc.cost();

	// 3b. Check results
	//      (Can't compare String object NAMES, need to compare chars!!)
	assertEquals(expectedResult, testOutput, 
		     "Expected: " + expectedResult 
		     + ", but got: " + testOutput);

	
	expectedResult = 0.65;
	testOutput = pe.cost();
	assertEquals(expectedResult, testOutput,
		     "Expected: " + expectedResult
		     + ", but got: " + testOutput);
	
	expectedResult = 0.85;
	testOutput = ps.cost();
	assertEquals(expectedResult, testOutput,
		     "Expected: " + expectedResult
		     + ", but got: " + testOutput);   
	
	expectedResult = 0.75;
	testOutput = sp.cost();
	assertEquals(expectedResult, testOutput,
		     "Expected: " + expectedResult
		     + ", but got: " + testOutput);
	
	expectedResult = 0.70;
	testOutput = wa.cost();
	assertEquals(expectedResult, testOutput,
		     "Expected: " + expectedResult
		     + ", but got: " + testOutput);
 }

    @Test
    public void testToString() {
	// 1. Prep for test
	// 1a. Make object that has method needing testing.
	    Cookie cookie = new SugarCookie();
	    ChocolateChips cc = new ChocolateChips(cookie);
	    Pecans pe = new Pecans(cookie);
	    PowderedSugar ps = new PowderedSugar(cookie);
	    Sprinkles sp = new Sprinkles(cookie);
	    Walnuts wa = new Walnuts(cookie);

	// 1b. Declare actual and expected outputs
	String expectedResult = "[[Sugar,315,$ 0.5]Chocolate Chips,180,$ 0.45]";
	String testOutput = null;

	// 1c. Save current System.out and set to new stream we can read.
	PrintStream origOut = System.out;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream newOut = new PrintStream(baos);
	System.setOut(newOut);

	// 2. Conduct method test (print/println call toString automatically)
	System.out.print(cc);

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
	
	expectedResult = "[[Sugar,315,$ 0.5]Pecans,120,$ 0.15]";
	baos = new ByteArrayOutputStream();
	newOut = new PrintStream(baos);
	System.setOut(newOut);
	System.out.print(pe);
	System.out.flush();
	testOutput = baos.toString();
	System.setOut(origOut);

	assertTrue(expectedResult.equals(testOutput),
		   "Expected :'" + expectedResult
		   + "' but got '" + testOutput + "'.");
	
	expectedResult = "[[Sugar,315,$ 0.5]Powdered Sugar,160,$ 0.35]";
	baos = new ByteArrayOutputStream();
	newOut = new PrintStream(baos);
	System.setOut(newOut);
	System.out.print(ps);
	System.out.flush();
	testOutput = baos.toString();
	System.setOut(origOut);

	assertTrue(expectedResult.equals(testOutput),
		   "Expected :'" + expectedResult
		   + "' but got '" + testOutput + "'.");    
	
	expectedResult = "[[Sugar,315,$ 0.5]Sprinkles,150,$ 0.25]";
	baos = new ByteArrayOutputStream();
	newOut = new PrintStream(baos);
	System.setOut(newOut);
	System.out.print(sp);
	System.out.flush();
	testOutput = baos.toString();
	System.setOut(origOut);

	assertTrue(expectedResult.equals(testOutput),
		   "Expected :'" + expectedResult
		   + "' but got '" + testOutput + "'.");
	
	expectedResult = "[[Sugar,315,$ 0.5]Walnuts,135,$ 0.2]";
	baos = new ByteArrayOutputStream();
	newOut = new PrintStream(baos);
	System.setOut(newOut);
	System.out.print(wa);
	System.out.flush();
	testOutput = baos.toString();
	System.setOut(origOut);

	assertTrue(expectedResult.equals(testOutput),
		   "Expected :'" + expectedResult
		   + "' but got '" + testOutput + "'.");
	}

	@Test
	public void TestAll() {
	Cookie cookie = new ChocolateChips(new Pecans(new PowderedSugar(new Sprinkles(new Walnuts(new SugarCookie())))));
	
	String expectedResult = "Sugar, Walnuts, Sprinkles, Powdered Sugar, Pecans, Chocolate Chips";
	String testOutput = cookie.getDescription();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult
		   + "' but got '" + testOutput + "'.");	
	
	int expectedResult2 = 1060;
	int testOutput2 = cookie.calories();
	assertEquals(expectedResult2, testOutput2, 
		     "Expected: " + expectedResult2
		     + ", but got: " + testOutput2);
	
	double expectedResult3 = 1.90;
	double testOutput3 = cookie.cost() + 0.0000000000000003;
	assertEquals(expectedResult3, testOutput3,
		     "Expected: " + expectedResult3
		     + ", but got: " + testOutput3);

	expectedResult = "[[[[[[Sugar,315,$ 0.5]Walnuts,135,$ 0.2]Sprinkles,150,$ 0.25]Powdered Sugar,160,$ 0.35]Pecans,120,$ 0.15]Chocolate Chips,180,$ 0.45]";
	PrintStream origOut = System.out;
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream newOut = new PrintStream(baos);
	System.setOut(newOut);
	System.out.print(cookie);
	System.out.flush();
	testOutput = baos.toString();
	System.setOut(origOut);
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	}
}
