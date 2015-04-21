package trees;

/**
 * Created by Monish on 3/17/14.
 */

class wrapper {
	int value;
	boolean isPrevBST = true;
	
	public wrapper(int v,boolean b) {
		value = v;
		isPrevBST = b;
	}
	
	public wrapper(int v){
		value =v;
	}
}

public class isBST {
	

	// Min-Max way
	public static boolean isBST(TreeNode root) {
		return isBSTHelper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	private static boolean isBSTHelper(TreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.value < min || root.value > max) {
			return false;
		} else
			return isBSTHelper(root.left, min, root.value)
					&& isBSTHelper(root.right, root.value, max);
	}

	// In-Order - with static
	public static int last_value = Integer.MIN_VALUE;
	public static boolean isBST3(TreeNode root) {
		if (root == null)
			return true;
		if (!isBST3(root.left))
			return false;

		if (last_value > root.value)
			return false;
		else
			last_value = root.value;

		if (!isBST3(root.right))
			return false;

		return true;

	}

	// In-Order
	public static boolean isBST2(TreeNode root) {
		return isBST2Helper(root, new wrapper(Integer.MIN_VALUE)).isPrevBST;
	}

	private static wrapper isBST2Helper(TreeNode root, wrapper w) {
		if(root==null)
			return w;
		wrapper w2 =isBST2Helper(root.left,w);
		if(!w2.isPrevBST)
			return w2;
		if(root.value<w2.value){
			w2.isPrevBST = false;
			return w2;
		} else 
			w2.value = root.value;
		
		if(!isBST2Helper(root.right,w2).isPrevBST){
			return w2;
		}
		
		return w2;
	}

	public static boolean isBST2Helper(TreeNode root, TreeNode root2) {
		if (root == null) {
			return true;
		}
		if (root2 == null) {
			isBST2Helper(root.left, root);
		}
		return true;
	}

}
