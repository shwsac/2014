package dynamicprogramming;

import java.util.Arrays;

public class CountHops {

	private static int countHops(int n) {
		int[] counts = new int[n + 1];
		Arrays.fill(counts, -1);
		return countHopsHelper(n, counts);
	}

	private static int countHopsHelper(int n, int[] counts) {
		if (n < 0)
			return 0;
		else if (n == 0)
			return 1;
		else if (counts[n] > -1)
			return counts[n];
		else {
			counts[n] = countHopsHelper(n - 1, counts)
					+ countHopsHelper(n - 2, counts)
					+ countHopsHelper(n - 3, counts);
			return counts[n];
		}
	}

	public static void main(String[] args) {
		for (int i = 0; i < 39; i++) {
			int c1 = countHops(i);
		
			System.out.println(i + " " + c1 );
		}
	}
}
