package dynamicprogramming;

import java.util.Arrays;

public class MinCoinChange {
  public static int[] denom = { 25, 10, 5, 1 };

  public static int minChange(int n) {
    if (n == 0)
      return 0;
    int res = Integer.MAX_VALUE;
    for (int i = 0; i < denom.length; i++) {

      if (n >= denom[i]) {
        int temp = minChange(n - denom[i]);
        if (temp + 1 < res)
          res = temp + 1;
      }
    }
    return res;

  }

  public static int minHelper(int n, int[] res) {
    if (res[n] >= 0)
      return res[n];
    if (n == 0) {
      res[n] = 0;
    } else {
      for (int i = 0; i < denom.length; i++) {

        if (n >= denom[i]) {
          int temp = minHelper(n - denom[i], res);
          if (res[n] < 0 || temp + 1 < res[n])
            res[n] = temp + 1;
        }
      }
    }
    return res[n];

  }

  public static int minChangeDP(int n) {
    if (n == 0)
      return 0;
    int[] res = new int[n + 1];
    Arrays.fill(res, -1);
    return minHelper(n, res);

  }

  public static void main(String[] args) {

    System.out.println(minChangeDP(40));

  }

}
