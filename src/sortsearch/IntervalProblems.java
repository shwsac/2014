package sortsearch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

class Interval {
  Integer startTime;
  Integer endTime;

  public Interval(int s, int e) {
    startTime = s;
    endTime = e;
  }

  public String toString() {
    StringBuilder i = new StringBuilder();
    i.append("(" + startTime + "," + endTime + ") ");
    return i.toString();

  }

}

public class IntervalProblems {

   
  public static int countConcurrent(List<Interval> input) {
    return 0;
  }
  public static List<Interval> union(List<Interval> input) {
    List<Interval> result = new ArrayList<Interval>();
    Integer start = Integer.MAX_VALUE;
    Integer end = Integer.MIN_VALUE;
    for (Interval i : input) {
      if (i.startTime > end) {
        if (start != Integer.MAX_VALUE) {
          result.add(new Interval(start, end));
        }
        start = i.startTime;
        end = i.endTime;
      } else if (i.endTime > end) {
        end = i.endTime;
      }

    }
    if (start != Integer.MAX_VALUE) {
      result.add(new Interval(start, end));
    }

    return result;
  }

  public static void print(List<Interval> input) {
    if(input==null||input.size()==0)
      System.err.print("null");
    for (Interval i : input) {
      System.out.print(i);
    }
  }

  public static void main(String[] args) {
    Random r = new Random();
    List<Interval> input = new ArrayList<Interval>();
    for (int i = 0; i < 5; i++) {
      int start = r.nextInt(50);
      int end = start+r.nextInt(50);
      //if(start<=end)
      input.add(new Interval(start, end));
    }

    print(input);
    Collections.sort(input, new Comparator<Interval>() {
      public int compare(Interval one, Interval two) {
        if (one.startTime.compareTo(two.startTime) != 0)
          return one.startTime.compareTo(two.startTime);
        else
          return one.endTime.compareTo(two.endTime);
      }
    });
    System.out.println();
    print(input);
    System.out.println();
    
    
    List<Interval> union2 = union(input);
    print(union2);
    
    ArrayList<Interval> I = new ArrayList<Interval>();
    I.add(new Interval(1, 4));
    I.add(new Interval(2, 8));
    I.add(new Interval(3, 6));
    I.add(new Interval(3, 5));
    I.add(new Interval(7, 10));
    I.add(new Interval(9, 11));
    
    System.out.println();
    print(I);
    Collections.sort(I, new Comparator<Interval>() {
      public int compare(Interval one, Interval two) {
        if (one.startTime.compareTo(two.startTime) != 0)
          return one.startTime.compareTo(two.startTime);
        else
          return one.endTime.compareTo(two.endTime);
      }
    });
    System.out.println();
    print(I);
    System.out.println();
    
    
    List<Interval> resI = union(I);
    print(resI);
  }

}
