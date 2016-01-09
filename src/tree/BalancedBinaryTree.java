package tree;

public class BalancedBinaryTree {
	
	class Entry{
		public int height;
		public boolean balanced;
	}
	
    public boolean isBalanced(TreeNode root) {
    	return checkTree(root).balanced;
    }
    
    private Entry checkTree(TreeNode root) {
    	Entry entry = new Entry();
    	if (root == null) {
    		entry.height = 0;
    		entry.balanced = true;
    	} else {
    		Entry left = checkTree(root.left);
    		Entry right = checkTree(root.right);
    		entry.height = Math.max(left.height, right.height) + 1;
    		entry.balanced = Math.abs(left.height - right.height) <= 1 && left.balanced && right.balanced;
    	}
    	return entry;
    }
    
}
