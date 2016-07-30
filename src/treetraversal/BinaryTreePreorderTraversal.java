package treetraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        preorder(res, root);
        return res;
    }
    
    private void preorder(List<Integer> res, TreeNode root) {
    	if (root != null) {
    		res.add(root.val);
    		preorder(res, root.left);
    		preorder(res, root.right);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
