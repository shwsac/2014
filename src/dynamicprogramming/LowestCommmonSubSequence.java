package dynamicprogramming;

public class LowestCommmonSubSequence {

	public static int getLCSLength(String first, String second) {
		if (first == null || second == null) {
			return -1;
		}
		int[][] lcsArray = new int[first.length() + 1][second.length() + 1];
		for (int i = 0; i <= first.length(); i++) {
			for (int j = 0; j <= second.length(); j++) {
				if (i == 0 || j == 0) {
					lcsArray[i][j] = 0;
				} else if (first.charAt(i - 1) == second.charAt(j - 1)) {
					lcsArray[i][j] = 1 + lcsArray[i - 1][j - 1];
				} else {
					lcsArray[i][j] = Math.max(lcsArray[i][j - 1],
							lcsArray[i - 1][j]);
				}

			}
		}

		return lcsArray[first.length()][second.length()];
	}

	public static String getLCS(String first, String second) {
		if (first == null || second == null) {
			return null;
		}
		int[][] lcsArray = new int[first.length() + 1][second.length() + 1];
		for (int i = 0; i <= first.length(); i++) {
			for (int j = 0; j <= second.length(); j++) {
				if (i == 0 || j == 0) {
					lcsArray[i][j] = 0;
				} else if (first.charAt(i - 1) == second.charAt(j - 1)) {
					lcsArray[i][j] = 1 + lcsArray[i - 1][j - 1];
				} else {
					lcsArray[i][j] = Math.max(lcsArray[i - 1][j],
							lcsArray[i][j - 1]);
				}

			}

		}
		char[] lcs = new char[lcsArray[first.length()][second.length()]];
		int index = lcs.length - 1;
		int i = first.length();
		int j = second.length();
		while (i > 0 && j > 0) {
			if (first.charAt(i - 1) == second.charAt(j - 1)) {
				lcs[index--] = first.charAt(i - 1);
				i--;
				j--;
			} else if (lcsArray[i][j - 1] > lcsArray[i - 1][j]) {
				j--;
			} else {
				i--;
			}

		}
		return new String(lcs);
	}

	public static void main(String[] args) {
		String first = "monishbhagat";
		String second = "shwetasachdeva";
		System.out.println(getLCSLength(first, second));
		System.out.println(getLCS(first, second));
	}

}
