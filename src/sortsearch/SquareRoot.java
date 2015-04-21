package sortsearch;

public class SquareRoot {
	public static final Double EPSILON = 0.00001;

	private static double compare(double a, double b) {
		double val = (a - b) / b;
		// if (val > EPSILON)
		// return 1;
		// else if (val < -EPSILON)
		// return -1;
		// else
		// return 0;
		return val > EPSILON ? 1 : val < -EPSILON ? -1 : 0;

	}

	public static double getSqrt(double number) {
		double l = 0.0, r = 0.0;
		double res = 0.0;
		if (compare(number, 1) < 0) {
			l = number;
			r = 1.0;
		} else {
			l = 1.0;
			r = number;
		}

		while (compare(l, r) == -1) {
			double m = l + (r - l) * 0.5;
			double sqVal = m * m;
			if (compare(sqVal, number) == 0)
				return m;
			else if (compare(sqVal, number) == 1)
				r = m;
			else
				l = m;
		}
		return l;
	}

	public static void main(String[] args) {
		System.out.println((getSqrt(4)));
	}

}
