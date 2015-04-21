package linkedlists;

public class SwapKNodes {

	public static Node swapAlternate(Node head) {
		if (head == null)
			return null;
		if( head.next==null){
			return head;
		
		}
		Node prev= head;
		
		Node curr = head.next;
		head= curr;
		
		
		while (true) {
			Node next = curr.next;			
			curr.next =prev; 
			if(next==null | next.next==null){
				prev.next= next;
				break;
			}
			prev.next=next.next;

			prev= next;			
			curr=prev.next;

		}

		// 1 2 3 4 5
		// 1 2 3 4
		return head;
	}

	public static Node swap(Node head, int k) {
		if (k <= 0)
			return head;
		Node prev1 = null;
		Node curr1 = head;
		int count = 0;
		while (curr1 != null && count++ < k - 1) {
			prev1 = curr1;
			curr1 = curr1.next;
		}

		if (curr1 == null)
			return head;
		Node n1 = curr1;
		while (curr1.next != null) {
			count++;
			curr1 = curr1.next;
		}
		System.out.println("\nLength" + count);
		curr1 = head;
		Node prev2 = null;
		int last_count = 0;
		while (last_count < count - k) {
			prev2 = curr1;
			curr1 = curr1.next;
			last_count++;
		}
		Node n2 = curr1;
		if (n1 == n2)
			return head;
		else if (prev1 == n2) {
			prev2.next = n1;
			n2.next = n1.next;
			n1.next = n2;

		} else if (prev2 == n1) {
			prev1.next = n2;
			n1.next = n2.next;
			n2.next = n1;

		} else {
			if (prev1 != null)
				prev1.next = n2;
			else {
				head = n2;
			}
			if (prev2 != null)
				prev2.next = n1;
			else
				head = n1;

			Node nxtTemp = n2.next;
			n2.next = n1.next;
			n1.next = nxtTemp;
		}
		return head;
	}

	public static Node swap2(Node head, int k) {

		Node ptr = head;
		int length = 1;

		// Get length of the linked list
		while (ptr.next != null) {
			length++;
			ptr = ptr.next;
		}
		// return in cases where no change required.
		if (k > length || k == 0 || 2 * length - 1 == k) {
			return head;
		}
		Node n1 = head;
		Node prev1 = null;
		int count = 1;
		while (count < k) {
			prev1 = n1;
			n1 = n1.next;
			count++;
		}
		Node n2 = head;
		Node prev2 = null;
		count = 1;
		while (count < length - k + 1) {
			prev2 = n2;
			n2 = n2.next;
			count++;
		}

		if (prev1 != null) {
			prev1.next = n2;
		}
		if (prev2 != null) {
			prev2.next = n1;
		}
		Node nextTemp = n1.next;
		n1.next = n2.next;
		n2.next = nextTemp;

		if (k == 1) {
			head = n2;
		}
		if (k == length) {
			head = n1;
		}
		// System.out.println(length);
		return head;
	}

	public static void main(String[] args) {
		Node n = new Node(1);
		Node n1 = n;
		int i = 2;
		while (i < 10) {
			Node n2 = new Node(i++);
			n1.next = n2;
			n1 = n1.next;
		}
		n1 = n;
		while (n1 != null) {
			System.out.print(n1.value + " ");
			n1 = n1.next;
		}
		System.out.println(" ");
		//Swap kth node test.
//		int count = 1;
//		n1 = n;
//		while (count < 10) {
//			n1 = swap2(n1, count);
//			Node n2 = n1;
//			while (n2 != null) {
//				System.out.print(n2.value + " ");
//				n2 = n2.next;
//			}
//			System.out.println();
//			count++;
//		}
		
		n1 = swapAlternate(n);
		while (n1 != null) {
			System.out.print(n1.value + " ");
			n1 = n1.next;
		}

	}
}
