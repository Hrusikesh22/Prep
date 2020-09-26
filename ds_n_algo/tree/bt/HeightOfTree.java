package ds_n_algo.tree.bt;

import ds_n_algo.tree.BTNode;
import ds_n_algo.tree.BTPrinter;
import ds_n_algo.tree.utils.TreeUtils;

/**
 * Depth~Height of tree - O(n)
 * 
 * Height of tree : Max(R.Left, R.Right)+1
 * Likewise Minimum Height of tree : Min(R.Left, R.Right)+1
 * 
 * @since 18/08/20
 */
public class HeightOfTree {
	public static void main(String[] s) {
		BTNode root = new BTNode(1);
		root.setLeft(new BTNode(2));
		root.setRight(new BTNode(3));
		root.getLeft().setLeft(new BTNode(4));
		root.getLeft().setRight(new BTNode(5));
		root.getLeft().getRight().setLeft(new BTNode(6));

		TreeUtils.print("I/P : Binary Tree");
		BTPrinter.printTree(root);
		
		TreeUtils.print("O/P : Height of Tree - " + height(root));
	}
	
	public static int height(BTNode root ) {
		
		if(root == null) 
			return 0;
		
		return Math.max( height(root.left), height(root.right) ) + 1;
	}
}



/*
      1               
     / \       
    /   \     
   2     3       
  / \           
 /   \          
 4   5           
    /           
    6           

 */
