package trees;

class TN {
  int val;
  TN left;
  TN right;
  TN parent;
}

public class InOrderSucc {
  
  public static TN getInorderSucc(TN n) {
    if(n == null) {
      return null;
    }
    if(n.parent==null || n.right!=null) {
      return getLeftMostChild(n.right);
    } else{
      TN prnt = n.parent;
      TN chld = n;
      while(prnt!=null && prnt.left!=chld) {
        chld = prnt;
        prnt = prnt.parent;
      }
      return prnt;
    }
  }

  private static TN getLeftMostChild(TN right) {
    if(right==null) {
      return null;
    }
    while(right.left!=null) {
      right = right.left;
    }
    return right;
  }



}
