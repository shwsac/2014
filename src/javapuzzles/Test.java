package javapuzzles;


public class Test {

  public static boolean isOdd(int i) {
    return i % 2 == 1 || i % 2 == -1;
    // return i % 2 == 1; << This doesn't work.
  }

  public static void main(String[] args) {
    
    
    System.out.println(isOdd(-3));
    System.out.println(-5 % 3);
  }
}
