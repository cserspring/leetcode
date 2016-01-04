package treetraversal;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
 
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	inorder(root, res);
    	return res;
    }
    
    private void inorder(TreeNode root, List<Integer> res) {
    	if (root != null) {
    		inorder(root.left, res);
    		res.add(root.val);
    		inorder(root.right, res);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
