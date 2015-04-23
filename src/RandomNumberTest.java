import java.util.Random;


public class RandomNumberTest {

  public static int atoi(String input) {
    
    if(input== null) {
      throw new IllegalArgumentException("Enter Valid Input String");
    }
    int result =0;
    for(int i = 0; i< input.length(); i++) {
      result = result * 10 + input.charAt(i) - '0';      
    }
    
    return result;
  }
  
  public String itoa(int i) {
    if(i == 0)
      return "0";
    boolean isNegative = false;
    if(i < 0) {
      isNegative = true;
      i = i * -1;
    }
    StringBuilder sb = new StringBuilder();
    while(i>0) {
      int temp = i %10;
      sb.append(temp);
      i = i/10;
    }    
    return sb.toString();    
  }
  
  
  public static void main(String[] args) {
    Random r = new Random();
    for(int i = 0; i < 100 ; i++) {
      System.out.println(atoi(""+i+""));
    }
  }
  
}
