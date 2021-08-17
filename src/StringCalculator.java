public class StringCalculator {
	public int add(String input) {
			if(input.isEmpty())
				return 0;
			else if(input.contains(",")) {
				String[] digit=input.split(",");
					return Integer.parseInt(digit[0])+Integer.parseInt(digit[1]);	
			}
			else
				return Integer.parseInt(input);
	}
}
