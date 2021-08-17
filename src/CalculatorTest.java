import static org.junit.Assert.*;
import org.junit.Test;

public class CalculatorTest {

	StringCalculator s=new StringCalculator();
	@Test
	public void EmptyString() {
		assertEquals(0,s.add(""));
	}
	
	@Test
	public void AnyNumber() {
		assertEquals(1,s.add("1"));
	}
	
	@Test
	public void TwoNumber() {
		assertEquals(3,s.add("1,2"));
	}
	
	@Test
	public void MultipleNumbers() {
		assertEquals(6,s.add("1,2,3"));
	}
	
	@Test
	public void NewLineNumbers() {
		assertEquals(6,s.add("1\n2,3"));
	}
	
	@Test
	public void ChangeDelimeter() {
		assertEquals(3,s.add("//;\n1;2"));
	}
	
	@Test
	public void ChangeAsRegexDelimeter() {
		assertEquals(3,s.add("//.\n1.2"));
	}
}
