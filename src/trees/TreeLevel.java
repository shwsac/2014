package trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeLevel {
	
	public static ArrayList<LinkedList<TreeNode>> createLevelListsDFS(TreeNode root){
		ArrayList<LinkedList<TreeNode>> results = new ArrayList<LinkedList<TreeNode>>();
		
		createLevelListsHelper(root,results,0);
		return results;
	}
	
	private static void createLevelListsHelper(TreeNode root, ArrayList<LinkedList<TreeNode>> results,int level){
		if(root==null){
			return;
		}
		if(results.size()==level){
			
			results.add(new LinkedList<TreeNode>());
		}
		results.get(level).add(root);
		createLevelListsHelper(root.left, results, level+1);
		createLevelListsHelper(root.right, results, level+1);
		
	}
	
	public static ArrayList<Double> getLevelAvg(TreeNode root){
		if(root==null)
			return null;
		ArrayList<Double> results = new ArrayList<Double>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		
		while(!queue.isEmpty()){
			int count=0;
			Double avg = 0.0;
		   LinkedList<TreeNode> childQ = new LinkedList<TreeNode>();
			for(TreeNode t: queue){
			   if(t.left!=null)
				   childQ.add(t.left);
			   if(t.right!=null)
				   childQ.add(t.right);
			   avg+=t.value;
			   count++;
		   }
			avg= avg/count;
			results.add(avg);
			queue = childQ;
		}
		
		return results;
	}
	public static ArrayList<TreeNode> getRightBoundary(TreeNode root){
		if(root==null)
			return null;
		ArrayList<TreeNode> results = new ArrayList<TreeNode>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		while(!queue.isEmpty()){
			LinkedList<TreeNode> childQ = new LinkedList<TreeNode>();
			for(TreeNode t: queue){
				if(queue.indexOf(t)==queue.size()-1){
					results.add(t);
				}
				if(t.left!=null)
					childQ.add(t.left);
				if(t.right!=null)
					childQ.add(t.right);
			}
			queue = childQ;
		}
		return results;
	}
	public static ArrayList<LinkedList<TreeNode>> createLevelListsBFS(TreeNode root) {
		ArrayList<LinkedList<TreeNode>> results = new ArrayList<LinkedList<TreeNode>>();
		LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
		if (root != null) {
			queue.add(root);
		}
		while (!queue.isEmpty()) {
			results.add(queue);
			LinkedList<TreeNode> childQueue = new LinkedList<TreeNode>();
			for (TreeNode parent : queue) {
				if (parent.left != null) {
					childQueue.add(parent.left);
				}
				if (parent.right != null) {
					childQueue.add(parent.right);
				}
			}
			queue = childQueue;
		}
		return results;
	}
}
