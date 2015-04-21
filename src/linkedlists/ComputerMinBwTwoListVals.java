package linkedlists;

import mystructures.MyEntry;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class ComputerMinBwTwoListVals {
  public static void main(String[] args) {
    List<MyEntry<Integer, Character>> ll = new LinkedList<MyEntry<Integer, Character>>();
    for (int i = 0; i < 10; i++) {
      MyEntry<Integer, Character> entry1 = new MyEntry<Integer, Character>(i,
          'a');
      ll.add(entry1);

    }

    for (int i = 0; i < 10; i++) {
      MyEntry<Integer, Character> entry2 = new MyEntry<Integer, Character>(
          i + 1, 'b');
      ll.add(entry2);
    }
    
    Collections.sort(ll, new Comparator<MyEntry<Integer,Character>>() {
      public int compare(MyEntry<Integer,Character> obj1,MyEntry<Integer,Character> obj2) {
        return obj1.getKey().compareTo(obj2.getKey());
      }
    });
    Iterator<MyEntry<Integer,Character>> itr = ll.iterator();
    while(itr.hasNext()) {
      MyEntry<Integer,Character> next = (MyEntry<Integer,Character>)itr.next();
      System.out.print(next.getKey()+"" + next.getValue()+"  , " );
    }
  }

}
