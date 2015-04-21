public class Fibonacci {

	public static void main(String[] args) {
		for (int i = 0; i < 12; i++) {
			System.out.print(fibDp(i) + " , ");
		}
		System.out.println();
		for (int i = 0; i < 12; i++) {
			System.out.print(fibItr(i) + " , ");
		}

	}

	private static int fibItr(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;
		int p0 = 0;
		int p1 = 1;
		int count = 1;
		int res = 0;
		while (count++ < i) {
			res = p0 + p1;
			p0 = p1;
			p1 = res;
			

		}
		return res;
	}

	private static int fibDp(int i) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;

		else {
			int[] fibArray = new int[i + 1];
			fibArray[0] = 0;
			fibArray[1] = 1;
			return fibHelper(i, fibArray);
		}
	}

	private static int fibHelper(int i, int[] fibArray) {
		if (i == 0)
			return 0;
		if (i == 1)
			return 1;
		if (fibArray[i] == 0)
			fibArray[i] = fibHelper(i - 1, fibArray)
					+ fibHelper(i - 2, fibArray);

		return fibArray[i];
	}

}
