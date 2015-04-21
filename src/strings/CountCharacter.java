package strings;

import java.util.HashMap;

public class CountCharacter {

	public static Character countChars(String s) {
		int maxCount = 0;
		Character c= null;
		HashMap<Character, Integer> charCountMap = new HashMap<Character, Integer>();
		for (int index =0;index<s.length();index++) {
			Character nextChar = s.charAt(index);
			if (charCountMap.get(nextChar) == null) {
				charCountMap.put(nextChar, 0);
			}
			charCountMap.put(nextChar, charCountMap.get(nextChar)+1);
			if(maxCount<charCountMap.get(nextChar)){
				maxCount =charCountMap.get(nextChar);
				c = nextChar;
			}
		}
		return c;
	}

	public static void main(String[] args) {
		String s = "Hello World";
		System.out.println(countChars(s));

	}

}
