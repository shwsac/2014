package dynamicprogramming;

import java.util.Arrays;

public class MinRemoval {
  public static int minRemovalDP(int[] input, int start, int end) {
    int[][] res = new int[end + 1][end + 1];
    for (int i = 0; i < end + 1; i++) {
      Arrays.fill(res[i], -1);
    }
    return minHelper(input, start, end, res);
  }

  private static int minHelper(int[] input, int start, int end, int[][] res) {
    if (start >= end)
      return 0;
    else if (res[start][end] >= 0) {
      return res[start][end];
    } else {
      int min = getMin(input, start, end);
      int max = getMax(input, start, end);
      if (2 * min > max) {
        res[start][end] = 0;
        return res[start][end];
      } else {
        res[start][end] = 1 + Math.min(minHelper(input, start + 1, end, res),
            minHelper(input, start, end - 1, res));
        return res[start][end];
      }

    }
  }

  public static int minRemoval(int[] input, int start, int end) {

    if (start >= end)
      return 0;
    int min = getMin(input, start, end);
    int max = getMax(input, start, end);
    if (2 * min > max) {
     //  System.out.println(min +"  : " + max);
      return 0;
    } else {
      return 1 + Math.min(minRemoval(input, start + 1, end),
          minRemoval(input, start, end - 1));
    }

  }

  private static int getMin(int[] input, int start, int end) {

    int res = input[start];
    for (int i = start + 1; i <= end; i++) {
      if (input[i] < res)
        res = input[i];
    }
    return res;
  }

  private static int getMax(int[] input, int start, int end) {
    int res = input[start];
    for (int i = start + 1; i <= end; i++) {
      if (input[i] > res)
        res = input[i];
    }
    return res;
  }

  public static void main(String[] args) {
    int[] arr = {20, 7, 5, 6};
    System.out.println(minRemoval(arr, 0, arr.length-1));
    System.out.println(minRemovalDP(arr, 0, arr.length-1));
  }

}
