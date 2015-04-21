package stackandqueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class MaxSlidingWindow {

  public static void main(String[] args) {
    //int[] arr = { 20, 7, 5, 6 };
    int[] arr = {1 ,3 ,-1, -3, 5, 3, 6, 7};
    System.out.println(Arrays.toString(arr));
    maxSliding(arr, 3);

  }

  private static void maxSliding(int[] arr, int k) {
    if (arr == null)
      return;
    else {
      ArrayList<Integer> res = new ArrayList<Integer>();
      LinkedList<Integer> pq = new LinkedList<Integer>();

      for (int i = 0; i < k && i < arr.length; i++) {
        while (pq.size() > 0 && pq.peek() < arr[i]) {
          pq.remove();
        }
        pq.add(arr[i]);
      }

      for (int i = k; i < arr.length; i++) {

        res.add(pq.peek());
        while(pq.size()>k) {
          pq.remove();
        }
        while (pq.size() > 0 && pq.peek() < arr[i]) {
          pq.remove();
        }
        pq.add(arr[i]);

      }
      res.add(pq.remove());
      System.out.println(res.toString());
    }

  }
}
