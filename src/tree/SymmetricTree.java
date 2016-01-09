package tree;

import java.util.Stack;

public class SymmetricTree {

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        Stack<TreeNode> stack1 = new Stack<TreeNode>();
        Stack<TreeNode> stack2 = new Stack<TreeNode>();
        TreeNode p = root.left;
        TreeNode q = root.right;
        while ((p != null && q != null) || (!stack1.isEmpty() && !stack2.isEmpty())) {
        	while (p != null && q != null) {
        		stack1.push(p);
        		p = p.left;
        		stack2.push(q);
        		q = q.right;
        	} 
        	
        	if (p != null || q != null) return false;
        	
        	if (stack1.isEmpty() && stack1.isEmpty()) return true;
        	if (stack1.isEmpty() || stack1.isEmpty()) return false;
        	
        	TreeNode node1 = stack1.pop();
        	TreeNode node2 = stack2.pop();
        	if (node1.val != node2.val) return false;
        	p = node1.right;
        	q = node2.left;        	
        }
        
        return p == null && q == null && stack1.isEmpty() && stack2.isEmpty();
    }
    
}
