import java.util.Iterator;


public class BSTIterator implements Iterator {

	class BSTNode{
		int value;
		BSTNode left;
		BSTNode right;
	}
	
	BSTNode root;
	BSTNode curr = root;
	
	public BSTIterator(BSTNode i){
		root =i;
		curr = getLeftMost();
	}
	
	private BSTNode getLeftMost() {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean hasNext() {
		if(curr ==null)
			return false;
			else return true;
	}

	@Override
	public BSTNode next() {
		BSTNode retNode = curr;
		if(curr!=null)
		curr = getInorderSuccessor();
		return retNode;
	}

	private BSTNode getInorderSuccessor() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void remove() {
		// TODO Auto-generated method stub
		
	}

}
