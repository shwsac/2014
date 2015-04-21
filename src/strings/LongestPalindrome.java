package strings;

public class LongestPalindrome {

	private static String expandAroundCenter(String s, int start, int end) {
		while (start >= 0 && end <= s.length() - 1
				&& s.charAt(start) == s.charAt(end)) {
			start--;
			end++;			
		}
		return s.substring(start+1, end);
	}

	public static String getLongestPalindrome(String input) {
		if (input.length() == 0)
			return new String("");

		String longestPalindrome = input.substring(0, 1);
		for (int i = 0; i < input.length(); i++) {
			String newP = expandAroundCenter(input, i, i);
			if (newP.length() > longestPalindrome.length()) {
				longestPalindrome = newP;
			}

			newP = expandAroundCenter(input, i, i + 1);
			if (newP.length() > longestPalindrome.length()) {
				longestPalindrome = newP;
			}
		}
		return longestPalindrome;
	}

	public static void main(String[] args) {

		System.out.println(getLongestPalindrome("monnoish"));
	}
}
