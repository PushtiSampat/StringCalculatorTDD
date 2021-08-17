import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class StringCalculator {
	public int add(String input) {
			if(input.isEmpty())
				return 0;
			else if(input.startsWith("//")) {
				int sum=0,num;
				if(input.contains("[") && input.contains("]")) {
					Matcher matchString=Pattern.compile("//(\\[)(.*)(\\])\n(.*)").matcher(input);
					matchString.matches();
					String userDelimeter=matchString.group(2);
					String deliNumber=matchString.group(4);
					
					String s=Pattern.quote(userDelimeter);
					char s1[]=s.substring(2).toCharArray();
					for(int i=0;i<deliNumber.length();i++)
					{
						for(int j=0;j<s1.length;j++){
							if(deliNumber.contains(String.valueOf(s1[j]))){
								deliNumber=deliNumber.replace(s1[j],'\n');
							}
						}
					}
					
					String onlyNumber[]=deliNumber.split("\n");	
					for(String number1:onlyNumber){
						for(int i=0;i<number1.length();i++) {
							if(number1!="\n"){
								num=Integer.parseInt(number1);
								if(num>1000)
									num=0;
								sum=sum+num;
							}
						}
					}
					return sum;
				}
				else {
					Matcher matchString=Pattern.compile("//(.*)\n(.*)").matcher(input);
					matchString.matches();
					String userDelimeter=matchString.group(1);
					String deliNumber=matchString.group(2);
					String onlyNumber[]=deliNumber.split(Pattern.quote(userDelimeter));	
					for(int i=0;i<onlyNumber.length;i++) {
						num=Integer.parseInt(onlyNumber[i]);
						if(num>1000)
							num=0;
						sum=sum+num;
					}
					return sum;
				}		
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
				int sum=0,num;
				String[] digit=input.split(",|\n");
				for(int i=0;i<digit.length;i++) {
					num=Integer.parseInt(digit[i]);
					if(num>1000)
						num=0;
					sum=sum+num;
				}
				return sum;
			}
			else
				return Integer.parseInt(input);
	}
}
