package array;

import java.util.Arrays;
public class StockProfit {
	static void maxProfit(int[] stock) {
	    int tempMin = stock[0];
	    int tempMinIndex = 0;
	    
	    int maxProfit = 0;
	    
	    int tempMax = stock[0];
	    int tempMaxIndex = 0;
	    
	    int globalMax = stock[0];
	    int globalMin = stock[0];
	    
	    for (int i = 1; i < stock.length; i++) {
	        if (tempMin > stock[i]) {
	            tempMin = stock[i];
	            tempMinIndex = i;

	        }
	        if (tempMax < stock[i] || tempMinIndex > tempMaxIndex) {
	            tempMax = stock[i];
	            tempMaxIndex = i;

	        }
	        if ((tempMax - tempMin) > maxProfit ) {
	            globalMax = tempMax;
	            globalMin = tempMin;
	            maxProfit = tempMax - tempMin;
	        }
	    }
	    System.out.println("Start : " + globalMin + " End : " + globalMax + " Profit : " + maxProfit);
	}
    public static void main(String[] args) {
         //int stock[] = {5,1, 3, 5, 2, 5,1, 8, 9, 20, 2, 13, 25, 13, 11, 3, 5, 9, 22};
        int stock[] = {1,2,3,4,5};
//        int stock[] = {5, 4,10, 7, 12,1};
//        int stock[] = {5, 6,8,2,4,2};
//        int stock[] = {5,4,3,2,1};
//        int stock[] = {5,1, 10, 4, 6, 2 , 1,14,1};
//        int stock[] = {1,2,1,2,1,2,1,2,1};
        System.out.println(Arrays.toString(stock));
        maxProfit(stock);
    }
}
