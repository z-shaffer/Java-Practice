
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class TestRubberDuck {

    // Fields used between test methods need to be static
    // Every test needs a Duck object, and some output recapture objects
    static Duck d;  
    static PrintStream originalOut;
    static ByteArrayOutputStream baos;
    static PrintStream newOut;

    @BeforeEach
    void init() {
	FlyBehavior nf = new NoFly();
	d = new RubberDuck("me", nf);
	originalOut = System.out;     // save to restore later
	baos = new ByteArrayOutputStream();
	newOut = new PrintStream(baos);
	System.setOut(newOut);
    }

    @AfterEach
    void cleanup() {
	System.setOut(originalOut);
    }

    // Not a JUnit helper, just a regular helper!
    private String getActualOutput() {
	System.out.flush();
	return baos.toString();
    }
	@Test
    void testDisplay() {
	// Test prep done in @BeforeEach methods
	
	// Run the test
	d.display();

	// Check results
	String actualOutput = getActualOutput();
	String expectedOutput = "I'm a Rubber duck named me.\n";
	assertEquals(expectedOutput, actualOutput);

	// Test cleanup now done in @AfterEach methods
   } 
	@Test
    void testQuack() {
	// Test prep done in @BeforeEach methods
	
	// Run the test
	d.quack();

	// Check results
	String actualOutput = getActualOutput();
	String expectedOutput = "me says squeak.\n";
	assertEquals(expectedOutput, actualOutput);

	// Test cleanup now done in @AfterEach methods
   }
	@Test
    void testswim() {
	// Test prep done in @BeforeEach methods
	
	// Run the test
	d.swim();

	// Check results
	String actualOutput = getActualOutput();
	String expectedOutput = "me's floatin'...\n";
	assertEquals(expectedOutput, actualOutput);

	// Test cleanup now done in @AfterEach methods
     
    }
}
