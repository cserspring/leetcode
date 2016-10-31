package bst;

public class LowestCommonAncestorOfABinarySearchTree {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    	if (root == null) return null;
    	if (root.val > p.val && root.val > q.val)
    		return lowestCommonAncestor(root.left, p, q);
    	if (root.val < p.val && root.val < q.val)
    		return lowestCommonAncestor(root.right, p, q);
    	if (p.val == q.val)
    		return p;
    	return root;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
