package sortsearch;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.TreeMap;

public class TreeMapProblem {
  
  public static void main(String[] args) {
    TreeMap<Integer, LinkedList<String>> tMap = new TreeMap<Integer, LinkedList<String>>(new Comparator<Integer>() {
      public int compare(Integer one, Integer two) {
        return two.compareTo(one);
      }
    });
    LinkedList<String> ll = new LinkedList<String>();
    tMap.put(90, new LinkedList<String>());
    ll = tMap.get(90);
    ll.add("Monisha");
    tMap.put(90,ll) ;
    ll.add("Miya");
    tMap.put(50, new LinkedList<String>());
    ll = tMap.get(50);
    ll.add("Monish");
    tMap.put(50,ll) ;
    tMap.put(60, new LinkedList<String>());
    ll = tMap.get(60);
    ll.add("is");
    tMap.put(60,ll) ;
    tMap.put(70, new LinkedList<String>());
    ll = tMap.get(70);
    ll.add("Msh");
    ll.add("M");
    tMap.put(70,ll) ;
    tMap.put(80, new LinkedList<String>());
    ll = tMap.get(80);
    ll.add("BBB");
    tMap.put(80,ll) ;
   
    
    
    for(Integer i : tMap.keySet()) {
      ll = tMap.get(i);
      System.out.print(i + " : ");
      for(String s : ll) {
        System.out.print(s+ " ");
      }
      System.out.println();
    }
  }

}
