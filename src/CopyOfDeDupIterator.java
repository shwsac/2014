import java.util.Iterator;
import java.util.LinkedList;

public class CopyOfDeDupIterator<E> implements Iterator<E> {

	E next ;
	Iterator<E> itr;

	public CopyOfDeDupIterator(Iterator<E> iter) {
		itr = iter;
		
	}

	@Override
	public boolean hasNext() {
		if(itr.hasNext())
		if (next != null) {
			return true;
		}
		return false;
	}

	@Override
	public E next() {
		E item=null;
		while (itr.hasNext()) {
			item = (E) itr.next();
			if (!item.equals(next)) {
				E temp = next;
				next = item;
				return temp;
			}

		}
		next = item;
		return next;
	}

	@Override
	public void remove() {
		itr.remove();
	}

	public static void main(String[] args) {

		LinkedList<Integer> list = new LinkedList<Integer>();
		for (int i = 0; i < 11; i++) {
			list.add(i);
			list.add(i);
		}

		Iterator<Integer> itr = list.iterator();
		while (itr.hasNext()) {
			System.out.print(itr.next() + " ");
		}

		System.out.println();
		itr = list.iterator();
		CopyOfDeDupIterator deDup = new CopyOfDeDupIterator(itr);
		while (deDup.hasNext()) {
			System.out.print(deDup.next() + " ");
		}
		
//		if(deDup.hasNext())
//			System.out.print(deDup.next() + " ");
//		if(deDup.hasNext())
//			System.out.print(deDup.next() + " ");
//		if(deDup.hasNext())
//			System.out.print(deDup.next() + " ");
//		if(deDup.hasNext())
//			System.out.print(deDup.next() + " ");
//		if(deDup.hasNext())
//			System.out.print(deDup.next() + " ");
	}
}
