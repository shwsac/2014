package dynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class WordBreak {

  public static boolean wordBreak(String s, Set<String> dict) {
    boolean[] sArray = new boolean[s.length() + 1];
    sArray[0] = true;
    for (int i = 0; i < s.length(); i++) {
      if (!sArray[i]) {
        continue;
      }
      for (String str : dict) {
        int len = str.length();
        int end = i + len;
        if (end > s.length()) {
          continue;
        }
        if (sArray[end]) {
          continue;
        }
        if (s.substring(i, end).equals(str)) {
          sArray[end] = true;
        }
      }
    }
    return sArray[s.length()];
  }

  public static void main(String[] args) {

    String s = "mynameismonishismyname";
    Set<String> dict = new HashSet<String>();
    dict.add("monish");
    dict.add("is");
    dict.add("name");
    dict.add("my");
    System.out.println(wordBreak(s, dict));
  }
}
