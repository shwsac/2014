package strings;

public class atoi {
	public static void main(String[] args){
		String s = "12345";
		int result =0;
		for(int i =0;i<s.length();i++){
			result = result*10 + s.charAt(i)-'0';			
		}
		
		System.out.println(result);
	}
}
