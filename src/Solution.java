
import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
public class Solution {
	

public static int numberOfChanges(List<Integer> inputList)
    {
        if(inputList.isEmpty())
            return 0;
        List<Integer> processedList = new ArrayList<Integer>(inputList.size());
        for(int i = 0; i < processedList.size(); ++i)
            processedList.set(i, -1);        
        int ncomponents = 1, count = 0;
        processedList.set(0, 0);
        for(int i = 0; i < inputList.size(); ++i)
        {
            if( numberHelper(inputList, processedList, i, count++) )
                ++ncomponents;
        }
        
        return ncomponents-1;        
    }
    public static Boolean numberHelper(List<Integer> inputList, List<Integer> processedList, int i, int currentCount)
    {        
        if(i == 0)
            return false;
        if(processedList.get(i) > 0 && processedList.get(i) != currentCount )
            return false;
        if(processedList.get(i) == currentCount)
            return true;
        processedList.set(i, currentCount);
        
        return numberHelper(inputList, processedList, inputList.get(i), currentCount);  
    }

	
    public static void main(String args[] ) throws Exception {
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s=br.readLine();
        LinkedList<Integer> l = new LinkedList<Integer>();
        int number = Integer.parseInt(s);
        for(int i =0;i<number;i++){
            s=br.readLine();
            int nextNum = Integer.parseInt(s);
            l.add(nextNum);            
        }
       
       // System.out.println(numberOfChanges(l));
    }
}