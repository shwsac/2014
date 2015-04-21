package array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import com.epi.Pair;

public class SmallestSetCoveringSet {
	  public static Pair<Integer, Integer> find_smallest_subarray_covering_subset(
			     ArrayList<String> largeSet, ArrayList<String> smallSet) {
			   HashSet<String> smallDict = new HashSet<String>(smallSet);
			   HashMap<String, Integer> count_Q = new HashMap<String, Integer>();
			   int l = 0, r = 0;
			   Pair<Integer, Integer> res = new Pair<Integer, Integer>(-1, -1);
			  //Main loop
			   while (r < largeSet.size()) {
			     // Keep moving r until it reaches end or count_Q has |Q| items.
			     while (r < largeSet.size() && count_Q.size() < smallSet.size()) {
			       if (smallDict.contains(largeSet.get(r))) {         
			         count_Q.put(largeSet.get(r), count_Q.containsKey(largeSet.get(r))?count_Q.get(largeSet.get(r))+1:1);         
			       }
			       ++r;
			     }
			  
			     if (count_Q.size() == smallSet.size() &&  // found |Q| keywords.
			         ((res.getFirst() == -1 && res.getSecond() == -1) ||
			          r - 1 - l < res.getSecond() - res.getFirst())) {
			       res.setFirst(l);
			       res.setSecond(r - 1);
			     }
			  
			     // Keep moving l until it reaches end or count_Q has less |Q| items.
			     while (l < r && count_Q.size() == smallSet.size()) {
			       if (smallDict.contains(largeSet.get(l))) {
			         int it = count_Q.get(largeSet.get(l));
			         count_Q.put(largeSet.get(l), --it);
			         if (it == 0) {
			           count_Q.remove(largeSet.get(l));
			           if ((res.getFirst() == -1 && res.getSecond() == -1) ||
			               r - 1 - l < res.getSecond() - res.getFirst()) {
			             res.setFirst(l);
			             res.setSecond(r - 1);
			           }
			         }
			       }
			       ++l;
			     }
			   }
			   return res;
			  }
			  

}
