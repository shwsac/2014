import java.util.Arrays;

public class MaxProductPair {

  public static int[] getMaxPair(int[] input) {
    if (input.length < 2) {
      throw new IllegalArgumentException(
          "Input should contain at least 2 integers");
    }
    int[] maxNeg = new int[2];
    Arrays.fill(maxNeg, Integer.MAX_VALUE);
    int[] maxPos = new int[2];
    // Arrays.fill(maxPos, Integer.MIN_VALUE);
    for (int i : input) {
      if (i < 0) {
        if (i < maxNeg[0]) {
          maxNeg[1] = maxNeg[0];
          maxNeg[0] = i;
        } else if (i < maxNeg[1]) {
          maxNeg[1] = i;
        }
      } else if (i > 0) {
        if (i > maxPos[0]) {
          maxPos[1] = maxPos[0];
          maxPos[0] = i;
        } else if (i > maxPos[1]) {
          maxPos[1] = i;
        }
      }
    }
    if (maxNeg[1] != Integer.MAX_VALUE) {
      if (maxPos[0] * maxPos[1] > maxNeg[0] * maxNeg[1]) {
        return maxPos;
      } else {
        return maxNeg;
      }
    }
    return maxPos;
  }

  public static void main(String[] args) {

    int[] array = {};// {0,0,0,0,0,1,1};//{-5, -1, -7, -13, -4};//{1,2,3,4,5};
    System.out.println(Arrays.toString(getMaxPair(array)));

  }

}
