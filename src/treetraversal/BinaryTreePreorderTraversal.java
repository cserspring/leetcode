package treetraversal;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePreorderTraversal {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        while (!stack.isEmpty()) {
        	TreeNode node = stack.pop();
        	res.add(node.val);
        	if (node.right != null)
        		stack.push(node.right);
        	if (node.left != null) 
        		stack.push(node.left);
        }
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
