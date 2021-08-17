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
	

	@Test
	public void NegativeNotAllowed() {
		try {
			s.add("1,-1,2,-3,-4");
		}
		catch(RuntimeException e) {
			assertEquals("Negative are not allowed:-1,-3,-4",e.getMessage());
		}
	}
	
	@Test
	public void BiggerThanThousand() {
		assertEquals(3,s.add("1,1001,2"));
	}
	
	@Test
	public void DelimeterAnyLength() {
		assertEquals(6,s.add("//[***]\n1***2***3"));
	}
	
	@Test
	public void MultipleDelimeter() {
		assertEquals(11,s.add("//[%&^*]\n1%3^3%4"));
	}
	
	@Test
	public void MultipleDelimeterSqrBracket() {
		assertEquals(6,s.add("//[*][%]\n1*2%3"));
	}
	
	@Test
	public void LengthLongerThanOneChar() {
		assertEquals(11,s.add("//[%&^*]\n1%*3^*3&&%4"));
	}
	
	@Test
	public void LengthLongerThanOneDifferentChars() {
		assertEquals(11,s.add("//[%&@*#][*$]\n1%&@*#3*$3%&@*#4"));
	}
	
	@Test
	public void LengthLongerThanOneSingleRepeatChar() {
		assertEquals(12,s.add("//[^^^^][@@@]\n1^^^^3@@@3@@@4^^^1"));
	}
}
