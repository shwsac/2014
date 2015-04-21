package dynamicprogramming;

public class MinimumInsertionsToMakePalidrome {

	public static int minInsertionCountUsingLCS(String str) {
		String rev = reverseString(str);
		int len = LongestCommonSubseq.getLCSLength(str, rev);
		return str.length() - len;
	}
	
	public static int minInsertionCountDP(String str){
		System.out.println("Check geeks if you really want to know. I didn't understand it in one go.");
		return -1;
	}

	private static String reverseString(String str) {
		int start = 0;
		int end = str.length() - 1;
		char[] strArray = str.toCharArray();
		while (start < end) {
			char temp = strArray[start];
			strArray[start++] = strArray[end];
			strArray[end--] = temp;
		}
		return new String(strArray);
	}

	public static void main(String[] args) {
		System.out.println(minInsertionCountUsingLCS("monihsinom"));
	}

}
