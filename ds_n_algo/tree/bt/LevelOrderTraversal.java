package ds_n_algo.tree.bt;

import ds_n_algo.tree.BTNode;
import ds_n_algo.tree.BTPrinter;
import ds_n_algo.tree.utils.TreeUtils;

public class LevelOrderTraversal {
	public static void main(String[] s) {
		BTNode root = new BTNode(1);
		root.left = new BTNode(2);
		root.right = new BTNode(3);
		root.left.left = new BTNode(4);
		root.left.right = new BTNode(5);
		root.right.left = new BTNode(6);
		root.right.right = new BTNode(7);
		
		TreeUtils.print("I/P : Binary Tree");
		BTPrinter.printTree(root);
	}
	
	//O(n)
	static void traverseIterative(BTNode root) {
		//TODO
	}
	
	//O(n2)
	static void traverseRecursive(BTNode root, int level) {
		//TODO
	}
}
