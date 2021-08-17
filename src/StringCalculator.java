public class StringCalculator {
	public int add(String input) {
			if(input.isEmpty())
				return 0;
			else if(input.contains(",")) {
				int sum=0;
				String[] digit=input.split(",");
				for(int i=0;i<digit.length;i++)	
					sum=sum+Integer.parseInt(digit[i]);
					return sum;	
			}
			else
				return Integer.parseInt(input);
	}
}
