package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeMap;

public class TreeVerticalOrder {

	public static void print(TreeNode root){
		if(root==null)
			System.out.println("null");
		TreeMap<Integer,LinkedList<TreeNode>> map = new TreeMap<Integer , LinkedList<TreeNode>>();
		printHelper(root,map,0);
		
		for(Integer i : map.keySet()){
			LinkedList<TreeNode> list = map.get(i);
			for(TreeNode t: list){
				System.out.print(t.value+ " ");
			}
			System.out.println();
		}
	}
	
	private static void printHelper(TreeNode root,TreeMap<Integer,LinkedList<TreeNode>> map, int level){
		
		if(!map.containsKey(level)){
			map.put(level,new LinkedList<TreeNode>());
		}
		map.get(level).add(root);
		if(root.left!=null){
			printHelper(root.left,map,level-1);
		}
		if(root.right!=null){
			printHelper(root.right,map,level+1);
		}
		
	}
	public static ArrayList<Integer> getSum(TreeNode root){
		
		return null;
	}
}
