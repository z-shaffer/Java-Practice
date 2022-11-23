import java.lang.IllegalArgumentException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


public class MintTest {

    @Test
    public void testInstance() {
	 Mint usdmint = null;
	 Mint cadmint = null;

	Mint expectedResult = null;
	Mint testOutput = null;
		//Check if both instances are the same
	testOutput = USDMint.getInstance();
	expectedResult = USDMint.getInstance(); 
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = CADMint.getInstance();
	expectedResult = CADMint.getInstance();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult
		   + "' but got '" + testOutput + "'.");

	
    }
	
	@Test
    public void testCreateCoin() {
	 Mint usdmint = USDMint.getInstance();
	 Mint cadmint = CADMint.getInstance();

	Coin expectedResult = null;
	Coin testOutput = null;

	
	expectedResult = new USDPenny();
	testOutput = usdmint.createCoin(.01);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = new USDNickel();
	testOutput = usdmint.createCoin(.05);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = new USDDime();
	testOutput = usdmint.createCoin(.10);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = new USDQuarter();
	testOutput = usdmint.createCoin(.25);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = new USDHalfDollar();
	testOutput = usdmint.createCoin(.50);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = new USDDollar();
	testOutput = usdmint.createCoin(1.00);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = new CADNickel();
	testOutput = cadmint.createCoin(.05);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
			"Expected:'" + expectedResult 
			+ "' but got '" + testOutput + "'.");

	expectedResult = new CADDime();
	testOutput = cadmint.createCoin(.1);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
			"Expected:'" + expectedResult 
			+ "' but got '" + testOutput + "'.");

	expectedResult = new CADQuarter();
	testOutput = cadmint.createCoin(.25);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
			"Expected:'" + expectedResult 
			+ "' but got '" + testOutput + "'.");
	
	expectedResult = new CADFiftyCent();
	testOutput = cadmint.createCoin(.5);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
			"Expected:'" + expectedResult 
			+ "' but got '" + testOutput + "'.");

	expectedResult = new CADLoonie();
	testOutput = cadmint.createCoin(1);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
			"Expected:'" + expectedResult 
			+ "' but got '" + testOutput + "'.");

	expectedResult = new CADToonie();
	testOutput = cadmint.createCoin(2);
	assertTrue(expectedResult.toString().equals(testOutput.toString()),
			"Expected:'" + expectedResult 
			+ "' but got '" + testOutput + "'.");
		   
    }

    
}