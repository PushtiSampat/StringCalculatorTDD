import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

	StringCalculator s=new StringCalculator();
	@Test
	public void EmptyString() {
		assertEquals(0,s.add(""));
	}
	
	
}