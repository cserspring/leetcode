package tree;

public class PathSum {
	
	boolean isFirstRoot = true;
	
    public boolean hasPathSum(TreeNode root, int sum) {
    	if (isFirstRoot && root == null) return false;
    	isFirstRoot = false;
        if (root == null && sum == 0) return true;
        if (root == null && sum != 0) return false;
        if (root.left == null || root.right == null) return root.left == null ? hasPathSum(root.right, sum - root.val) : hasPathSum(root.left, sum - root.val);
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }
    
}
