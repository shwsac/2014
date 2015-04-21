package sortsearch;

public class computeDivisionUsingBS {
	public static final Double EPSILON = 0.000000000001;

	private static double compare(double a, double b) {
		double val = (a - b) / b;
		return val > EPSILON ? 1 : val < -EPSILON ? -1 : 0;

	}

	public static double divide(double x, double y) {
		double res = 0.0;
		double l = 0.0, r = 0.0;
		if(compare(x,y)<0){
			

			l = 0.0;
			r = 1;
		}else {
			
			l = 1;
		    r = x;
		}
		while(compare(l,r)==-1){
			//System.out.println(l + "  Here  "+ r);
			double m = l + (r - l)*0.5;
			double product = y * m;
			if(compare(product,x)== 0)
				return m;
			else if(compare(product, x)==1){
			//	System.out.println(l + "  Here  "+ r+"  "+ product);
				r = m;
			} else
				l = m;
			
		}
		return r;
	}

	public static void main(String[] args) {
		System.out.println(divide(4,2));
	}

}
