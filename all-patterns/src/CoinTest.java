import java.lang.IllegalArgumentException;
import java.io.PrintStream;
import java.io.ByteArrayOutputStream;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;


public class CoinTest {

    static Coin usdpenny;
	static Coin usdnickel;
	static Coin usddime;
	static Coin usdquarter;
	static Coin usdhalfdollar;
	static Coin usddollar;
	static Coin cadnickel;
	static Coin caddime;
	static Coin cadquarter;
	static Coin cadfiftycent;
	static Coin cadloonie;
	static Coin cadtoonie;
	

	@BeforeEach
    void init() {
		usdpenny = new USDPenny();
	    usdnickel = new USDNickel();
	    usddime = new USDDime();
	    usdquarter = new USDQuarter();
	    usdhalfdollar = new USDHalfDollar();
	    usddollar = new USDDollar();
		
	 	cadnickel = new CADNickel();
	 	caddime = new CADDime();
	 	cadquarter = new CADQuarter();
	 	cadfiftycent = new CADFiftyCent();
	 	cadloonie = new CADLoonie();
	 	cadtoonie = new CADToonie();
    }
	
	@Test
    public void testConstructor() {
	try {
	    

	    assertNotNull(usdpenny);
	    assertNotNull(usdnickel);
	    assertNotNull(usddime);
	    assertNotNull(usdquarter);
	    assertNotNull(usdhalfdollar);
	    assertNotNull(usddollar);
		
	    assertNotNull(cadnickel);
	    assertNotNull(caddime);
	    assertNotNull(cadquarter);
	    assertNotNull(cadfiftycent);
	    assertNotNull(cadloonie);
	    assertNotNull(cadtoonie);
	}
	catch (Exception e) {
	    fail("Constructor threw exception: " + e.getMessage());
	}
    }

    @Test
    public void testType() {

	String expectedResult = null;
	String testOutput = null;

	expectedResult = "Penny";
	testOutput = usdpenny.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Nickel";
	testOutput = usdnickel.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Dime";
	testOutput = usddime.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Quarter";
	testOutput = usdquarter.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Half Dollar";
	testOutput = usdhalfdollar.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Dollar";
	testOutput = usddollar.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
	    
	expectedResult = "Nickel";
	testOutput = cadnickel.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Dime";
	testOutput = caddime.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Quarter";
	testOutput = cadquarter.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "FiftyCent";
	testOutput = cadfiftycent.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Loonie";
	testOutput = cadloonie.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "Toonie";
	testOutput = cadtoonie.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
	    
	expectedResult = "";
	testOutput = Coin.NULL.getType();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
    }

    @Test
    public void testValue() {
	 
	double expectedResult = 0;
	double testOutput = 0;

	expectedResult = 0.01;
	testOutput = usdpenny.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = 0.05;
	testOutput = usdnickel.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = 0.10;
	testOutput = usddime.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = 0.25;
	testOutput = usdquarter.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = 0.50;
	testOutput = usdhalfdollar.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = 1.00;
	testOutput = usddollar.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
	    
	expectedResult = 0.05;
	testOutput = cadnickel.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = 0.10;
	testOutput = caddime.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = 0.25;
	testOutput = cadquarter.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = 0.50;
	testOutput = cadfiftycent.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = 1.00;
	testOutput = cadloonie.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = 2.00;
	testOutput = cadtoonie.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
	    
	expectedResult = 0;
	testOutput = Coin.NULL.getValue();
	assertTrue(expectedResult == testOutput,
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
    }

    @Test
    public void testCode() {
	 

	String expectedResult = "";
	String testOutput = "";

	expectedResult = "USD";
	testOutput = usdpenny.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = usdnickel.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = usddime.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = usdquarter.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = usdhalfdollar.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = usddollar.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
	    
	expectedResult = "CAD";
	testOutput = cadnickel.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = caddime.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = cadquarter.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = cadfiftycent.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = cadloonie.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	testOutput = cadtoonie.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
	    
	expectedResult = "";
	testOutput = Coin.NULL.getCode();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
    }

    @Test
    public void testToString() {
	 

	String expectedResult = "";
	String testOutput = "";

	expectedResult = "[USDPenny: worth $0.01]";
	testOutput = usdpenny.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[USDNickel: worth $0.05]";
	testOutput = usdnickel.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[USDDime: worth $0.10]";
	testOutput = usddime.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[USDQuarter: worth $0.25]";
	testOutput = usdquarter.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[USDHalf Dollar: worth $0.50]";
	testOutput = usdhalfdollar.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[USDDollar: worth $1.00]";
	testOutput = usddollar.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
	    
	expectedResult = "[CADNickel: worth $0.05]";
	testOutput = cadnickel.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[CADDime: worth $0.10]";
	testOutput = caddime.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[CADQuarter: worth $0.25]";
	testOutput = cadquarter.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[CADFiftyCent: worth $0.50]";
	testOutput = cadfiftycent.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[CADLoonie: worth $1.00]";
	testOutput = cadloonie.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");

	expectedResult = "[CADToonie: worth $2.00]";
	testOutput = cadtoonie.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
	    
	expectedResult = "Could not manufacture coin.";
	testOutput = Coin.NULL.toString();
	assertTrue(expectedResult.equals(testOutput),
		   "Expected:'" + expectedResult 
		   + "' but got '" + testOutput + "'.");
    }
}