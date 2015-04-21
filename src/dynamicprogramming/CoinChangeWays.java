package dynamicprogramming;

public class CoinChangeWays {

  //public static int[] denom = { 25, 10, 5, 1 };
  public static int[] denom = {1,5,10, 25 };
  // 100 - 1-25, 2 - 25 , 3 -25 - 4 -25.
  public static int maxWays(int n, int d) {
    if (n == 0) {
      return 1;
    } else if (n < 0) {
      return 0;
    } else if (d >= denom.length && n >= 1) {
      return 0;
    } else {
      return maxWays(n, d + 1) + maxWays(n - denom[d], d);
    }
  }

  public static int maxWaysDP(int n) {
    int[] res = new int[n + 1];

    res[0] = 1;
    for (int i = 0; i < denom.length; i++) {
      for (int j = denom[i]; j <= n; j++) {
        res[j] += res[j - denom[i]];
      }
    }
    return res[n];
  }

  public static void main(String[] args) {
    System.out.println(maxWaysDP(6));
  }
}
