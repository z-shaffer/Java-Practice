
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

import java.io.PrintStream;
import java.io.ByteArrayOutputStream;

public class TestDuck {

    // Fields used between test methods need to be static
    // Every test needs a Duck object, and some output recapture objects
    static Duck d;  
    static PrintStream originalOut;
    static ByteArrayOutputStream baos;
    static PrintStream newOut;

    @BeforeEach
    void init() {
	FlyBehavior fb = new Flap();
	d = new MockDuck("me", fb);
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
    public void testFly() {
	// Prep

	// Test: method writes to System.out which has been redirected
	d.fly();

	// Check results
	String actualOutput = getActualOutput();
	String expectedOutput = "flapping!\n";
	assertEquals(expectedOutput, actualOutput);

	// Cleanup
    }

    @Test
    public void testQuack() {
	// Prep

	// Test: method writes to System.out which has been redirected
	d.quack();

	// Check results
	String actualOutput = getActualOutput();
	String expectedOutput = "me says Quack.\n";
	assertEquals(expectedOutput, actualOutput);

	// Cleanup
    }

    @Test
    public void testSwim() {
	// Prep

	// Test: method writes to System.out which has been redirected
	d.swim();

	// Check results
	String actualOutput = getActualOutput();
	String expectedOutput = "me's webbed feet a paddlin'...\n";
	assertEquals(expectedOutput, actualOutput);

	// Cleanup
    }
}

class MockDuck extends Duck {
    public MockDuck(String name, FlyBehavior fb) {
	super(name, fb);
    }
    public void display() { }
}
