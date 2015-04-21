package strings;

public class RemoveExtraSpaces {

  public static void main(String[] args) {
    String s = " I    love New   York ";
    System.out.println(s.length() + "(" + s + ")");
    String r = removeXSpaces(s);
    System.out.println(r.length() + "(" + r + ")");
  }

  private static String removeXSpaces(String s) {
    String res = "";
    char c = ' ';
    boolean flag = false;
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        if (!flag) {
          flag = true;
          res = res + " ";
        }
      } else {
        flag = false;
        res = res + s.charAt(i);
      }
    }
    return res;
  }

}
