package strings;

public class ReverseInt {
	
	public static int reverseInt(int num){
	//	System.out.println(" Num : "+ num);
		int res =0;
		while(num>0){
		//	System.out.println("result   " + res+ "   num % 10  " + num%10);
			res =res*10+ num%10;
			num = num/10;
		}
		return res;
		
	}
	public static void main(String[] args){
		System.out.println(reverseInt(45));
		
	//	System.out.println(reverseInt(045));
		
	}

}
