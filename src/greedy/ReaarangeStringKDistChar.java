package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.PriorityQueue;

/**
 * Given a string and a positive integer d. Some characters may be repeated in
 * the given string. Rearrange characters of the given string such that the same
 * characters become d distance away from each other. Note that there can be
 * many possible rearrangements, the output should be one of the possible
 * rearrangements. If no such arrangement is possible, that should also be
 * reported. Expected time complexity is O(n) where n is length of input string.
 * 
 * @author Monish
 * 
 */

public class ReaarangeStringKDistChar {

  public static void main(String[] args) {
    System.out.println(reArrange("abb", 2));
    System.out.println(reArrange("aacbbc", 3));
    System.out.println(reArrange("geeksforgeeks", 4));
    System.out.println(reArrange("aaa", 2));
  }

  private static String reArrange(String string, int k) {
    if (string == null) {
      return null;
    }
    HashMap<Character, Integer> countMap = new HashMap<Character, Integer>();
    for (Character c : string.toCharArray()) {
      if (!countMap.containsKey(c)) {
        countMap.put(c, 0);
      }
      countMap.put(c, countMap.get(c) + 1);
    }
    MyComparator comparator = new MyComparator();
    PriorityQueue<Entry<Character, Integer>> pq = new PriorityQueue<Entry<Character, Integer>>(
        countMap.entrySet().size(), comparator);
    pq.addAll(countMap.entrySet());
    char[] sArray = new char[string.length()];
    Arrays.fill(sArray, '\0');
    while (pq.size() != 0) {
      Entry<Character, Integer> val = pq.remove();
      for (int in = 0; in < sArray.length&&val.getValue()>0;) {
        if (sArray[in] == '\0') {
          sArray[in] = val.getKey();
          in += k;
          val.setValue(val.getValue() - 1);
        } else {
          in++;
        }
      }
      if (val.getValue() != 0) {
        System.out.println("Not possible! Returning original string");
        return  string;
      }
    }

    return new String(sArray);
  }

}

class MyComparator implements Comparator<Entry<Character, Integer>> {
  @Override
  public int compare(Entry<Character, Integer> one,
      Entry<Character, Integer> two) {
    return two.getValue().compareTo(one.getValue());
  }

}
