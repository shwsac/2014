package array;

import java.util.Arrays;

public class QuickSort {
	public static void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
		
	}

	private static void quickSort(int[] arr, int start, int end) {
		int i = start;
		int j = end;
		int pivot = arr[end];
		
		//int pivot = arr[(i + j) /2] ;
		System.out.println(pivot + " : pivot");
		System.out.println(Arrays.toString(arr));
		while (i <= j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}

			if (i <= j) {
				int temp =arr[i]; 
				arr[i] =  arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
			//System.out.println(Arrays.toString(arr));
		}
		if (start < j)
			quickSort(arr, start, j);
		if (i < end)
			quickSort(arr, i, end);
	}

	public static void main(String[] args) {

		int[] array = { 8,7,6,5,9,4,3,2,1 };

		quickSort(array);
		System.out.println(Arrays.toString(array));
	}
}
