package array;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

public class ProbablityTest {

	public static int[] mostFrequentSum(int n){
		if(n==0 || n ==1){
			return new int[0];
		}
		else{
			if(n%2==0){
				int[] arr = new int[1];
				arr[0] = (int) (3.5*n);
				return arr;
			}
			else{
				int[] arr = new int[2];
				
				arr[0]= (int)(3.5*n);
				arr[1] = (int)(3.5*n)+1;
				return arr;
			}		
			
		}
	
		
	}
	
	static int one2oneHundred(int[] dice) {
		   Random r = new Random();
		    while(true){
		    int index = r.nextInt(5);
		    int result =1400*(dice[r.nextInt(5)] -1)+100*(dice[r.nextInt(5)] -1) +
		    	
		    		500*(dice[r.nextInt(5)] -1)  + 200* (dice[r.nextInt(5)] -1)
		    		+300* (dice[r.nextInt(5)] -1) +1;
			//700*(dice[r.nextInt(5)] -1)+
		    //int result =(dice[r.nextInt(5)] -1)+ 6*(dice[r.nextInt(5)] -1)  + 36* (dice[r.nextInt(5)] -1) +1;
		    result= result/100;
		    if(result<=100)
		        return result;
		    }
		}
	
	public static void main(String[] args){
		Random r = new Random();
		int min = 0;
		int max = 0;
		HashMap<Integer,Integer> hmap = new HashMap<Integer,Integer>();
		for(int i = 0 ;i<100;i++){
			int[] dice = new int[5];
			for(int i1 = 0;i1 <dice.length;i1++){
				dice[i1] = r.nextInt(6)+1;
			}
			int num = one2oneHundred(dice);
		if(!hmap.containsKey(num)){
			hmap.put(num, 0);
			
		}
			hmap.put(num, hmap.get(num)+1);
			if(hmap.get(num)<min){
				min = hmap.get(num);
			}
			if(hmap.get(num)>max){
				max = hmap.get(num);
			}
		}
		System.out.println(min + "  "+ max);
		float randomness = 1 - ((float)(1-min) +(max - 1))/20; 
		//float randomness = ((float)(1000-min) +(max - 1000))/2000; 
		System.out.println(randomness);
	}
	
	
}
