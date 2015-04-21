package array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class SortArray {

  public static void main(String[] args) {
    
    String[] in = {"red", "blue", "green"};
    String[] ques = {"blue", "green","red", "blue", "green","blue", "green","blue","red", "green","red","blue", "green"};
    final HashMap<String, Integer> hMap = new HashMap<String,Integer>();
    int count =0;
    for(String s: in) {
      hMap.put(s, count++);
    }
    
    Arrays.sort(ques, new Comparator<String>() {
      public int compare(String one, String two) {
        return hMap.get(one).compareTo(hMap.get(two));
      }
    });
    
    for(String s: ques) {
      System.out.print(s+ " ");
    }
  }
}
