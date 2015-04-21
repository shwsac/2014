package array;

import java.util.Arrays;
import java.util.Random;

public class SuffleArray {
  public static void shuffle(int[] arr) {
    Random r = new Random();
    for (int i = 0; i < arr.length; i++) {
      int index = r.nextInt(arr.length - i) + i;
      int temp = arr[index];
      arr[index] = arr[i];
      arr[i] = temp;

    }
  }

  public static void main(String[] args) {
    int[] arr = {7,4,3,1,3,5,7, 1, 2, 3, 4, 5 };
    for (int i = 0; i < 5; i++) {
      shuffle(arr);
      System.out.println(Arrays.toString(arr));
    }

  }

}
