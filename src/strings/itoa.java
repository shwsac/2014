package strings;

public class itoa {
	public static void main(String[] args){
		int i = 12345;
		StringBuilder sb = new StringBuilder();
		while(i!=0){
			int r = i%10;
			sb.append(r);
			i=i/10;
		}
		sb.reverse();
		System.out.println(new String(sb));
	}
}
