package array;

import java.util.Arrays;

public class MergeKSortedArrays {
	
	

	public static int[] merge(int[][] arr, int k){
		int[] result = new int[arr[0].length*k];
		
		return result;
		
	}
	
	public static void main(String[] args) {

		int [][] arr = { {1, 3, 5, 7},
	            {2, 4, 6, 8},
	            {0, 9, 10, 11}} ;
		
		int [] result = merge(arr,arr.length);
		System.out.print(Arrays.toString(result));
	}

}
