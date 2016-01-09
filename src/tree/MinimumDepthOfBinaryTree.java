package tree;

public class MinimumDepthOfBinaryTree {
	
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null || root.right == null) return root.left == null ? (1 + minDepth(root.right)) : (1 + minDepth(root.left));
        return Math.min(1 + minDepth(root.left), 1 + minDepth(root.right));
    }
    
}
