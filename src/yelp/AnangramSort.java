package yelp;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

public class AnangramSort {

  public static String[] sortAnan(String[] input) {
    HashMap<String, LinkedList<String>> result = new HashMap<String, LinkedList<String>>();
    String[] output = new String[input.length];
    int index =0;
    for(String s: input) {
      String key = sort(s);
      if(!result.containsKey(key)){
        result.put(key, new LinkedList<String>());
      }
      result.get(key).add(s);
    }
    
    for(String keyString: result.keySet()) {
      LinkedList<String> list = result.get(keyString);
      for(String outString : list) {
       // System.out.print(outString+ "  ");
        output[index++] = outString;
      }
      //System.out.println();
    }
    return output;
  }
  
  private static String sort(String s) {

    char[] arr =s.toCharArray();
    Arrays.sort(arr);
    String out =new String(arr); 
    //System.out.println(s + " : "+ out);
    return out;
    
  }
  
  public static void main(String[] args) {
    
    String[] input = {"cat", "star", "act", "god", "arts", "dog", "rats","mon","nom","mno"};
    String[] output = sortAnan(input);
    for(String s: input) {
      System.out.print(s+ "  ");
    }
    System.out.println();
    for(String s: output) {
      System.out.print(s+ "  ");
    }
    
  }
}
