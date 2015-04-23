
public class RegexSolution {
  public static boolean isMatch(String s, String p) {

      if(p.length() == 0)
          return s.length() == 0;

      //p's length 1 is special case    
      if(p.length() == 1 || p.charAt(1) != '*'){
          if(s.length() < 1 || (p.charAt(0) != '.' && s.charAt(0) != p.charAt(0)))
              return false;
          return isMatch(s.substring(1), p.substring(1));    

      }else{
          int len = s.length();

          int i = -1; 
          while(i<len && (i < 0 || p.charAt(0) == '.' || p.charAt(0) == s.charAt(i))){
              if(isMatch(s.substring(i+1), p.substring(2)))
                  return true;
              i++;
          }
          return false;
      } 
  }
  
  
  public static boolean isMatch2(String r, String s) {
    // Case (2.) : starts with '^'.
    if (r.charAt(0) == '^') {
      return isMatchHere(r.substring(1), s);
    }

    for (int i = 0; i <= s.length(); ++i) {
      if (isMatchHere(r, s.substring(i))) {
        return true;
      }
    }
    return false;
  }

  private static boolean isMatchHere(String r, String s) {
    // Case (1.)
    if (r.isEmpty()) {
      return true;
    }

    // Case (2) : ends with '$'.
    if ("$".equals(r)) {
      return s.isEmpty();
    }

    // Case (4.)
    if (r.length() >= 2 && r.charAt(1) == '*') {
      for (int i = 0; i < s.length()
          && (r.charAt(0) == '.' || r.charAt(0) == s.charAt(i)); ++i) {
        if (isMatchHere(r.substring(2), s.substring(i + 1))) {
          return true;
        }
      }
      return isMatchHere(r.substring(2), s);
    }

    // Case (3.)
    return !s.isEmpty() && (r.charAt(0) == '.' || r.charAt(0) == s.charAt(0))
        && isMatchHere(r.substring(1), s.substring(1));
  }
  
  public static void main(String[] args) {
   String str = " baaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaba" ;
   String reg = "a*b" ;
    System.out.println(isMatch(str, reg));
    System.out.println(isMatch2(reg, str));
    
  }
}