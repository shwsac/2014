package array;

public class PrintTriangle {
	
	public static void printTraingleForm(int[] arr, int length){
		if(length<0){
			return;
		}
		int i=1;
		for(;i<=length;i++){
			
			System.out.print(arr[i-1]+",");
			arr[i-1] = arr[i] + arr[i-1];
		}
		System.out.println(arr[i-1]);
		printTraingleForm(arr, length-1);
	}
	
	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};
		
		printTraingleForm(arr,arr.length-1);
	}

}
