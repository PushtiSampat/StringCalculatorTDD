import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringCalculator {
	public int add(String input) {
			if(input.isEmpty())
				return 0;
			else if(input.startsWith("//")) {
				int num,sum=0;
				Matcher matchString=Pattern.compile("//(.)\n(.*)").matcher(input);
				matchString.matches();
				String userDelimeter=matchString.group(1);
				String deliNumber=matchString.group(2);
				String onlyNumber[]=deliNumber.split(Pattern.quote(userDelimeter));		
				for(int i=0;i<onlyNumber.length;i++) {
					num=Integer.parseInt(onlyNumber[i]);
					sum=sum+num;
				}
				return sum;
			}
			else if(input.contains("-") && input.contains(",")) {
				String[] digit=input.split(",");
				StringBuffer s=new StringBuffer();
				for(int i=0;i<digit.length;i++) {
					int num=Integer.parseInt(digit[i]);
					if(num<0) {
						s.append(digit[i]);
						s.append(",");
					}
				}
				s.deleteCharAt(s.length()-1);
				throw new RuntimeException("Negative are not allowed:" +s);
			}
			else if(input.contains(",") || input.contains("\n")) {
				int sum=0;
				String[] digit=input.split(",|\n");
				for(int i=0;i<digit.length;i++) {
					sum=sum+Integer.parseInt(digit[i]);
				}
				return sum;
			}
			else
				return Integer.parseInt(input);
	}
}
