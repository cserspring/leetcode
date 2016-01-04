package treetraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}
 
public class BinaryTreeInorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	Stack<TreeNode> stack = new Stack<TreeNode>();
    	while (root != null || !stack.isEmpty()) {
    		while (root != null) {
    			stack.push(root);
    			root = root.left;
    		}
    		if (!stack.isEmpty()) {
    			root = stack.pop();
    			res.add(root.val);
    			root = root.right;
    		}
    	}

    	return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
