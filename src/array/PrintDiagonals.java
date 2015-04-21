package array;

public class PrintDiagonals {

  public static void printD(int[][] arr) {

    for (int k = 0; k < arr[0].length; k++) {
      int i = 0;
      int j = k;
      while (j >= 0) {
        System.out.println(arr[i][j]);
        i++;
        j--;

      }

    }

    for (int k = 1; k < arr.length; k++) {
      int j = arr[0].length - 1;
      int i = k;
      while (j < arr.length) {
        System.out.print(arr[i][j]);
        j--;
        i++;
      }

    }
  }

  public static void printDiagonally(int[][] array) {

    // Get row number and column number
    int rowNum = array.length;
    int columnNum = array[0].length;

    // Print each diagonals that start at the first row
    for (int k = 0; k < columnNum; k++) {
      System.out.println();
      int x = 0; // Always start from the first row
      int y = k;
      while (y >= 0) {
        System.out.print(array[x++][y--]);
      }
    }

    // Print each diagonals that start at the last column (start from the second
    // row)
    for (int k = 1; k < rowNum; k++) {
      System.out.println();
      int y = columnNum - 1; // Always start from the last column
      int x = k;
      while (x < rowNum) {
        System.out.print(array[x++][y--]);
      }
    }

  } // End of printDiagonally()

  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
