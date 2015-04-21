package strings;

import java.util.Arrays;
import java.util.Comparator;

class RR{
  public static void executethis() {
    System.out.print("here");
  }
}

public class LexicographicIntegers {

  private static Integer[] sort(Integer[] arr) {
    Arrays.sort(arr, new Comparator<Integer>() {

      public int compare(Integer one, Integer two) {
        return one.toString().compareTo(two.toString());
      }
    });
    return arr;
  }

  private static void printFirstNLexi(int n) {
    for (int i = 1; i <= 9; i++) {
      int j = 1;
      while (j <= n) {
        for (int m = 0; m < j; m++) {
          if (m + j * i <= n) {
            System.out.print(m + j * i + ",");
            
          }
        }
        j *= 10;
      }
    }
  }

  public static void main(String[] args) {

    Integer[] arr = { 1, 11, 4, 22, 5, 66, 32, 5, 3, 22, 7, 1, 9, 0, 45, 321,
        56784, 2, 4 };
    
    String[] arr2 = {"A", "B", "C","AA"};
    
    System.out.println(Arrays.toString(arr));
    System.out.println(Arrays.toString(sort(arr)));
    Arrays.sort(arr);
    System.out.println(Arrays.toString(arr));
    printFirstNLexi(100);
    
    System.out.println("\n"+Arrays.toString(arr2));
   // System.out.println(Arrays.toString(sort(arr2)));
    Arrays.sort(arr2);
    System.out.println(Arrays.toString(arr2));
    
  }
}
