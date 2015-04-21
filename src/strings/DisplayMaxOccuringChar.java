package strings;

public class DisplayMaxOccuringChar {

  public static String getMaxOccChar(String s) {
    if (s == null || s.length() == 0) {
      return null;
    } else {
      int startIndex = 0;
      int endIndex = 0;
      int maxCount = 1;
      for (int i = 1; i < s.length(); i++) {
        if (s.charAt(i) != s.charAt(startIndex)) {
          if (i - startIndex > maxCount) {
            startIndex = i - startIndex;
            maxCount = i - startIndex;
            System.out.println(startIndex+" : "+maxCount);
          }
          startIndex = i;
        } 
      }
      if (s.length() - startIndex > maxCount) {
        startIndex = s.length() - startIndex;
        maxCount = s.length() - startIndex;
        System.out.println(startIndex+" : "+maxCount);
      }
      return s.substring(startIndex, endIndex + 1);
    }

  }

  public static void main(String[] args) {
    String s = "aaaaaa";
    System.out.println(getMaxOccChar(s));
  }

}
