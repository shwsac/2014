import java.util.BitSet;

public class AppleTest {

	public static void main(String[] args) {
		BitSet bs = new BitSet();
		String s = "PETERTHIEL";
//		int x = 'M' - 'A';
//		System.out.println(x);
		for (int i = 0; i < s.length(); i++) {
			int bitIndex = s.charAt(i) - 'A';
		//	System.out.println(bitIndex + " BI");
			if (bs.get(bitIndex))
				System.out.println(s.charAt(i) + " is dup");
			else
				bs.set(bitIndex);

		}
		System.out.println(bs.toString());

	}

}
