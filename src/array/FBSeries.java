package array;

import java.util.ArrayList;
import java.util.Arrays;

public class FBSeries {
	public static void main(String[] args){
		int[] arr = {1, 1, 2, 3, 3, 1};
		System.out.println(Arrays.toString(arr));
		int count =1;
		ArrayList<Integer> arrList = new ArrayList<Integer>();
		int current =arr[0];
		
		for(int i=1;i<  arr.length;i++){
			if(arr[i]!=current){
				arrList.add(count);
				arrList.add(current);
				current = arr[i];
				count=0;
			}
			count++;
		}		
		
		arrList.add(count);
		arrList.add(current);
		Integer[] newArray = new Integer[arrList.size()];
		newArray=arrList.toArray(newArray);
		System.out.println(Arrays.toString(newArray));
	}

}
