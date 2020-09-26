package ds_n_algo.tree.bt;

import ds_n_algo.tree.BTNode;

public class DiameterOfTree {
	
	public static void main(String[] s) {

	}
	
	static int ans=0;
	static int diameterOfBinaryTree(BTNode root) {
        depth(root);
        return ans==0? ans : ans - 1; // -1 for returning no of edges as diameter, not no of nodes.
    }
	static int depth(BTNode root) {
        
		if (root == null) 
        	return 0;
        
        int L = depth(root.left);
        int R = depth(root.right);
        
        ans = Math.max(ans, L+R+1);
        
        return Math.max(L, R) + 1;
    }
}
