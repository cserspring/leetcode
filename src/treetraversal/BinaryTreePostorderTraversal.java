package treetraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	Stack<TreeNode> stack1 = new Stack<TreeNode>();
    	Stack<TreeNode> stack2 = new Stack<TreeNode>();
    	if (root != null) stack1.push(root);
    	while (!stack1.isEmpty()) {
    		TreeNode node = stack1.pop();
    		stack2.push(node);
    		if (node.left != null) 
    			stack1.push(node.left);
    		if (node.right != null)
    			stack1.push(node.right);
    	}
    	
    	while (!stack2.isEmpty()) 
    		res.add(stack2.pop().val);
    	
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
