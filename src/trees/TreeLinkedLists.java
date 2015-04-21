package trees;

import java.util.LinkedList;

class LLNode<E> {
	E value;
	LLNode next;
	LLNode prev;

	public LLNode() {
		next = null;
		prev = null;
	}

	public LLNode(E val) {
		value = val;
	}
}

//class LL<E> {
//	LLNode<E> head;
//
//}

public class TreeLinkedLists {

	public static LLNode<TreeNode> BSTtoDLLInOrder(TreeNode root) {
		if (root != null) {
			LLNode<TreeNode> head = Helper(root, null);
			while (head.prev != null)
				head = head.prev;
			return head;
		}
		return null;
	}

	public static LLNode<TreeNode> Helper(TreeNode root, LLNode<TreeNode> prev) {
		if (root == null)
			return prev;
		LLNode<TreeNode> leftPrev = Helper(root.left, prev);
		LLNode<TreeNode> nextNode = new LLNode<TreeNode>(root);
		nextNode.prev = leftPrev;
		if (leftPrev != null) {
			leftPrev.next = nextNode;
		}
		LLNode<TreeNode> rightPrev = Helper(root.right, nextNode);
		return rightPrev;

	}

	public static LLNode<TreeNode> BSTtoDLLPreOrder(TreeNode root) {
		if (root != null) {
			LLNode<TreeNode> head = new LLNode<TreeNode>();
			
			 head = preHelper(root, null);
			 while (head.prev != null)
					head = head.prev;
			 return head;

		}
		return null;
	}

	public static LLNode<TreeNode> preHelper(TreeNode root, LLNode<TreeNode> prev) {
		if (root == null) {
			return prev;
		}
		LLNode<TreeNode> newNode = new LLNode<TreeNode>(root);
		newNode.prev=prev;
		if(prev!=null)
			prev.next= newNode;
		LLNode<TreeNode> leftPrev= preHelper(root.left,newNode);
		LLNode<TreeNode> rightPrev = preHelper(root.right, leftPrev);

		return rightPrev;
	}

	public static void main(String[] args) {
		TreeNode root = TreeNode.newNode(10);
		root.left = TreeNode.newNode(5);
		root.left.left = TreeNode.newNode(3);
		root.left.right = TreeNode.newNode(8);
		root.left.left.right = TreeNode.newNode(4);
		root.right = TreeNode.newNode(100);
		root.right.left = TreeNode.newNode(50);
		root.right.right = TreeNode.newNode(150);
		root.right.left.left = TreeNode.newNode(40);

		LLNode<TreeNode> node = BSTtoDLLInOrder(root);
		while (node != null) {
			System.out.print(node.value.value + " ");
			node = node.next;
		}
		System.out.println();
		LLNode<TreeNode> node2 = BSTtoDLLPreOrder(root);
		while (node2 != null) {
			System.out.print(node2.value.value + " ");
			node2 = node2.next;
		}
	}
}