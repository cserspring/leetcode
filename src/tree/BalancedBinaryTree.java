package tree;

public class BalancedBinaryTree {
	
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 &&
        		isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode root) {
    	if (root == null) return 0;
    	return Math.max(1 + height(root.left), 1 + height(root.right));
    }
    
}
