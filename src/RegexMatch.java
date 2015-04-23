
public class RegexMatch {
  
  public static boolean isMatch(String input, String regex, char wildChar) {    
    if(input.length()!= regex.length()) {
      if(input.length() == 0) {
        return false;
      }
      if(input.charAt(0) == wildChar) {
        return isMatch(input.substring(1),regex,wildChar);
      }
      if(regex.charAt(0)== '*') {
        wildChar = input.charAt(0);
        return isMatch(input.substring(1),regex.substring(1),wildChar);
      }
    }else {
      
    }
    
    return false;
  }
  public static void main(String[] args) {
    
    
  }

}
