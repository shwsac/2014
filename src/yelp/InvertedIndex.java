package yelp;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class InvertedIndex {

  class Location{
    int pageNumber;
    int wordNumber;
    
  }
  
  public static Map<String,Location> returnInvertedIndex(List<List<String>> input){
    Map<String,Location> result = new HashMap<String,Location>();
    int count=1;
    for(List<String> l : input) {
      
      for(String s: l) {
        if(result.containsKey(s)) {
          
        }
      }
    }
    return null;
  }
  
  public static void main(String[] args) {
    // TODO Auto-generated method stub

  }

}
