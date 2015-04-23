
public class MaxOnesReplace {

  public static int maxOnesIndex(int[] arr) {
    if(arr!=null) {
      int maxIndex = -1;
      int tempIndex = -1;
      int maxCount =0;
      int tempCount =0;
      boolean bitReplaced = false;
      for(int i=0; i < arr.length ; i++ ) {
       // System.out.println(maxCount+ " : " + i);
        if(arr[i] == 1) {
          tempCount++;          
        }else {
          if(bitReplaced) {
            if(maxCount < tempCount) {
              maxCount = tempCount;
              maxIndex = tempIndex;
            }
            tempIndex = i;
            tempCount = 1;
          }else {
            bitReplaced = true;
            tempCount++;
            tempIndex = i;
          }
        }
        
      }
      if(maxCount < tempCount) {
        maxCount = tempCount;
        maxIndex = tempIndex;
      }
      return maxIndex;
    }    
    return -1;
  }
  public static void main(String [] args) {
  //int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9,10,11,12};
    int[] arr = {1, 1, 0, 0, 1, 0, 1, 1, 1, 0, 1, 1, 1};
    System.out.println(maxOnesIndex(arr));
  }
  
}
