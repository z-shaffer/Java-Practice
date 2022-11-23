/* 
 * JUnit5 test class
 */

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class CalculatorTest {
	
	private Calculator calculator;

	@BeforeEach 
	public void init() {
		calculator = new Calculator();
	}

      @Test
      public void testEvaluate() {
	    int sum = calculator.evaluate("1+2+3");
	    assertEquals(6, sum);
      }
	@Test
      public void testEvaluate2() {
	    int sum2 = calculator.evaluate("3+4+5");
	    assertEquals(12, sum2);
      }
}
