// Copyright (c) 2013 Elements of Programming Interviews. All rights reserved.

package com.epi;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

// @exclude	
public class BigNumberMultiplication {
	

	public static void main(String[] args) {

		String s2 = "535049555751";
		String s1 = "495556525749555051";
		s1="12";
		s2="10";

		BigInt res = new BigInt(s1).multiply(new BigInt(s2));
		System.out
				.println(String.format("%s * %s = %s", s1, s2, res.toString()));

		System.out.println("multiplying using Java's BigInteger...");
		BigInteger result = new BigInteger(s1).multiply(new BigInteger(s2));
		System.out.println("answer = " + result.toString());

		assert (res.toString().equals(result.toString()));
		// }
	}

}

// @include
class BigInt {
	// @include
	int sign_; // -1 or 1;
	char[] digits_;

	BigInt(int capacity) {
		sign_ = 1;
		digits_ = new char[capacity];
	}

	BigInt(String s) {
		sign_ = s.charAt(0) == '-' ? -1 : 1;
		digits_ = new char[s.length() - (s.charAt(0) == '-' ? 1 : 0)];

		for (int i = s.length() - 1, j = 0; i >= (s.charAt(0) == '-' ? 1 : 0); --i, ++j) {
			if (Character.isDigit(s.charAt(i))) {
				digits_[j] = (char) (s.charAt(i) - '0');
			}
		}
	}

	BigInt multiply(BigInt n) {
		BigInt result = new BigInt(digits_.length + n.digits_.length);
		result.sign_ = sign_ * n.sign_;
		int i = 0, j = 0;
		for (i = 0; i < n.digits_.length; ++i) {
			if (n.digits_[i] != 0) {
				int carry = 0;
				for (j = 0; j < digits_.length || carry > 0; ++j) {					
					int n_digit = result.digits_[i + j]
							+ (j < digits_.length ? n.digits_[i] * digits_[j]
									: 0) + carry;
					result.digits_[i + j] = (char) (n_digit % 10);
					carry = n_digit / 10;
				}
			}
		}

		// If one number is 0, the result size should be 0.
		if ((digits_.length == 1 && digits_[0] == 0)
				|| (n.digits_.length == 1 && n.digits_[0] == 0)) {
			result.sign_ = 1;
			result.digits_ = Arrays.copyOf(result.digits_, 1);
		} else {
			result.digits_ = Arrays.copyOf(result.digits_, i + j - 1);
		}
		return result;
	}

	// @exclude
	public String toString() {
		StringBuilder s = new StringBuilder(sign_ > 0 ? "" : "-");

		for (int i = digits_.length - 1; i >= 0; --i) {
			s.append((char) (digits_[i] + '0'));
		}

		if (digits_.length == 0) {
			s.append('0');
		}
		return s.toString();
	}

}