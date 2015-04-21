package trees;

import java.util.ArrayList;
import java.util.LinkedList;

public class TreeNode {
	int value;
	TreeNode left;
	TreeNode right;

	public static TreeNode newNode(int val) {
		TreeNode treeNode = new TreeNode();
		treeNode.value = val;
		treeNode.left = treeNode.right = null;
		return treeNode;
	}

	public static void main(String[] args) {
		TreeNode root = newNode(10);
		root.left = newNode(5);
		root.left.left= newNode(15);
		root.right = newNode(100);
		root.right.left = newNode(50);
		root.right.right = newNode(150);
		root.right.left.left = newNode(40);

		// DLLNode node = convertDLLPreOrder(root);
		// DLLNode traverse = node;
		// while(traverse!=null){
		// System.out.print(traverse.val + " ");
		// traverse=traverse.next;
		// }

		// System.out.println(isBalanced(root));

		// printRootToLeafPaths(root);
		
		// Get level wise average
//		System.out.println(TreeLevel.getLevelAvg(root));
		// is BT a BST?
//		System.out.println(isBST.isBST2(root));
//		System.out.println(isBST.isBST3(root));
		
		// Get right boundary 
//		ArrayList<TreeNode> results = TreeBoundary.getRightBoundary(root);
//		for(TreeNode t : results){
//			System.out.print(t.value + " ");
//		}
		System.out.println();
//		results = TreeLevel.getRightBoundary(root);
//		for(TreeNode t : results){
//			System.out.print(t.value + " ");
//		}
//		
		//Print vertical order
		TreeVerticalOrder.print(root);
		ArrayList<LinkedList<TreeNode>> levelLists = TreeLevel
				.createLevelListsBFS(root);
		for (LinkedList<TreeNode> levelList : levelLists) {
			System.out.println();
			for(TreeNode t: levelList){
				System.out.print(t.value + " ");
				}
		}
		System.out.println();
		ArrayList<LinkedList<TreeNode>> levelLists2 = TreeLevel
				.createLevelListsDFS(root);
		for (LinkedList<TreeNode> levelList : levelLists2) {
			System.out.println();
			for(TreeNode t: levelList){
				System.out.print(t.value + " ");
				}
		}

	}
}
