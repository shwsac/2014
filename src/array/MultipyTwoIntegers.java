package array;

public class MultipyTwoIntegers {

	public static void main(String[] args){
		
		String s1= "123";
		String s2= "45";
		String result = null;
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int mul = 0;
		int carry = 0;
		int out = 0;
		int multiplier1=1;
		int multiplier2=1;
		for(int i = c1.length-1;i>=0;--i){
			
			for(int j = c2.length-1;j>=0;--j){
				int o = (c2[j] - '0') * (c1[i] - '0');
				mul = o%10;
				carry = o/10;
				System.out.println(mul+" "+carry);
			}
			multiplier1*=10;
		}
	}
}
