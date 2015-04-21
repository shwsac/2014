package array;

public class Fibonacci {

	public static int fib(int n){
		
		if(n<=1){
			return 1;
		}
		int f1=1;
		int f2=1;
		int fn= 0;
		for(int i =2; i<=n; i++){
			fn = f1+f2;
			f1 = f2;
			f2= fn;
		}
		return fn;
	}
	
	
	public static void main(String[] args){
		
		for(int i=0;i<10;i++){
		System.out.print(fib(i)+ "  ");
		}
	}
}
