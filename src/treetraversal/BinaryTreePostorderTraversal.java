package treetraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	postOrder(res, root);
    	return res;
    }
    
    private void postOrder(List<Integer> res, TreeNode root) {
    	if (root != null) {
    		postOrder(res, root.left);
    		postOrder(res, root.right);
    		res.add(root.val);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
