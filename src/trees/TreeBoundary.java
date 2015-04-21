package trees;

import java.util.ArrayList;

public class TreeBoundary {

	public static ArrayList<TreeNode> getRightBoundary(TreeNode root){
		if(root==null)
			return null;
		ArrayList<TreeNode> results = new ArrayList<TreeNode>();
		getRightBoundaryHelper(root,1,results);
		return results;
	}

	public static int maxLevel = 0;
	private static void getRightBoundaryHelper(TreeNode root,
			int level, ArrayList<TreeNode> results) {
		
		if(maxLevel<level){
			results.add(root);
			maxLevel=level;
		}
		if(root.right!=null)
			getRightBoundaryHelper(root.right, level+1, results);
	
		if(root.left!=null)
			getRightBoundaryHelper(root.left, level+1,  results);
		
	}
}
