package array;

import java.util.Arrays;

public class MinMax {

	private static int[] minmax(int a, int b) {
		int[] res = new int[2];
		if (a <= b) {
			res[0] = a;
			res[1] = b;
		} else {
			res[0] = b;
			res[1] = a;
		}
		return res;
	}

	public static int[] findMinMax(int[] arr) {
		int[] res = { -1, -1 };
		if (arr == null || arr.length == 0)
			return res;
		if (arr.length == 1) {
			res[0] = arr[0];
			res[1] = arr[0];
		} else {
			res = minmax(arr[0], arr[1]);
			for (int i = 2; i < arr.length; i = i + 2) {
				if (i + 1 < arr.length) {
					int[] localRes = minmax(arr[i], arr[i + 1]);
					res[0] = Math.min(localRes[0], res[0]);
					res[1] = Math.max(localRes[1], res[1]);
				} else {
					res[0] = Math.min(arr[i], res[0]);
					res[1] = Math.max(arr[i], res[1]);
				}
			}
		}

		return res;
	}

	public static void main(String[] args) {
		int[] arr = null;// {1,5,2,4,6,3,4,6,9,0,3,2,1,43,4,5,6,7};
		System.out.println(Arrays.toString(findMinMax(arr)));

	}

}
