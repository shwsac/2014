package yelp;

public class PascalPrintTraingle {

  public static void main(String[] args) {
    // TODO Auto-generated method stub

    int n = 5;
    int[] old = new int[n];
    old[0] = 1;
    int[] nArr = new int[n];
    System.out.println(1);
    for (int i = 1; i < n; i++) {
      for (int j = 0; j <= i; j++) {
        if (j == 0) {
          System.out.print(old[j] + " ");
          nArr[j] = old[j];
        } else if (j == i) {
          System.out.print(old[j - 1] + " ");
          nArr[j] = old[j - 1];
        } else {
          System.out.print(old[j] + old[j - 1]);
          System.out.print(" ");
          nArr[j] = old[j] + old[j - 1];
        }
      }
      old = nArr;
      nArr = new int[n];
      System.out.println();
    }
    int ROW = n;
    int[][] pascal = new int[ROW + 1][];
    pascal[1] = new int[1 + 2];
    pascal[1][1] = 1;
    for (int i = 2; i <= ROW; i++) {
      pascal[i] = new int[i + 2];
      for (int j = 1; j < pascal[i].length - 1; j++) {
        pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
      }
    }
    for (int i = 1; i <= ROW; i++) {
      for (int j = 1; j < pascal[i].length - 1; j++) {
        System.out.print(pascal[i][j] + " ");
      }
      System.out.println();
    }
  }
}
