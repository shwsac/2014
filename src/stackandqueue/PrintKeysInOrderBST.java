package stackandqueue;

import java.util.Stack;

class TreeNode {
  TreeNode left = null;
  TreeNode right = null;
  int val;

  public TreeNode(int v) {
    val = v;
    left = null;
    right = null;
  }
}

public class PrintKeysInOrderBST {

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(7);

    printBST(root);
  }

 
  public static void printBST(TreeNode root) {
    Stack<TreeNode> meraStack = new Stack<TreeNode>();
    if (root == null) {
      return;
    } else {
      TreeNode temp = root;
      while (true) {
        if (temp != null) {
          meraStack.push(temp);
          temp = temp.left;
        } else {
          if (!meraStack.isEmpty()) {
            temp = meraStack.pop();
            // flag = false;
            System.out.print(temp.val + "  ");
            temp = temp.right;
          } else {
            break;
          }
        }
      }

    }
  }
}
