package array;

import java.util.Arrays;
import java.util.Random;

public class BigIntegerMultiply {
	public static String multiply(String n1, String n2) {
		return null;
	}

	public static int[] multiply(int[] n1, int[] n2) {
		int[] result = new int[n1.length + n2.length];
		// result.sign_ = sign_ * n.sign_;
		int i = 0, j = 0;
		for (i = 0; i < n2.length; ++i) {
			System.out.print("n2[i] "+ (n2[i]-'0'-1) + "  ");
			if (n2[i]-'0'-1 != 0) {
				int carry = 0;
				for (j = 0; j < n1.length || carry > 0; ++j) {
					System.out.println(i + " : " + j + "  "+ result.length);
					int n_digit = result[i + j]
							+ (j < n1.length ? n2[i] * n1[j] : 0) + carry;
					result[i + j] = (n_digit % 10);
					carry = n_digit / 10;
				}
			}
		}
		if ((n1.length == 1 && n1[0] == 0)
				|| (n2.length == 1 && n2[0] == 0)) {
			
			result = Arrays.copyOf(result, 1);
		} else {
			result = Arrays.copyOf(result, i + j - 1);
		}
		
		return result;
	}

	public static void main(String[] args) {

		Random gen = new Random();
		String s2 = "535049555751";
		String s1 = "495556525749555051";
		s1="12";
		s2="10";
		int[] s1Arr = new int[s1.length()];
		int[] s2Arr = new int[s2.length()];

		// int result=0;
		for (int i = 0; i < s1.length(); i++) {
			s1Arr[i] = s1.charAt(i);
		}
		for (int i = 0; i < s2.length(); i++) {
			s2Arr[i] = s2.charAt(i);
		}
		int[] result = multiply(s1Arr, s2Arr);
		for (int i = result.length - 1; i >= 0; i++) {
			System.out.print(result[i]);
		}

		// 495556525749555051 * 535049555751 = 265147298951808422323468148301
	}
}
