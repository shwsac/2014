package strings;

public class FirstNonRepeatedChar {
  
  public static char getChar(String s) {
    int[] count= new int[256];
    for(int i =0; i < s.length();i++) {
      count[s.charAt(i)]++;
    }
    for(int i =0; i < s.length();i++) {
      if(count[s.charAt(i)]==1) {
        return s.charAt(i);
      }
    }
    
    return '\0';
  }
  
  public static void main(String[] args) {
    String s = "GeeksforGeeks";
    
    System.out.print(getChar(s));
  }

}
