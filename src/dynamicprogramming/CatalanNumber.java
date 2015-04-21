package dynamicprogramming;

public class CatalanNumber {
	public static int getNthCatalanNumberDP(int n) {
		if (n <= 1)
			return 1;
		else {
			int[] cNRes = new int[n + 1];
			cNRes[0] = 1;
			cNRes[1] = 1;

			for (int i = 2; i <= n; i++) {
				cNRes[i] = 0;
				for (int j = 0; j < i; j++) {
					cNRes[i] += cNRes[i - j - 1] * cNRes[j];
				}

			}

			return cNRes[n];
		}

	}

	public static void main(String[] args) {
		for (int i = 0; i < 50; i++) {
			System.out.print(getNthCatalanNumberDP(i) + "   ");
		}
	}

}
