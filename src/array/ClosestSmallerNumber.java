package array;

public class ClosestSmallerNumber {

	public static void main(String[] args) {

		int num = 4312;
		int div = 1;
		for (int i = 1; i < 4; i++) {
			div = div * 10;
			System.out.println(div);
			if ((num % div) < (num % (div * 10)) / 10){
				int x = num  %div;
				int y = (num % (div * 10))/10;
				num = num /(div*10);
				num = num * div * 10;
				System.out.println(num);
				num = num + x * 10+ y;
				break;
				}
				
		}
		System.out.println(num);
	}
}
