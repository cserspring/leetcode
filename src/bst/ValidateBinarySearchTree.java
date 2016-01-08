package bst;

public class ValidateBinarySearchTree {

	private boolean firstNode = true;
	
	private int lastValue = 0;
	
    public boolean isValidBST(TreeNode root) {
    	if (root == null) return true;
    	if (!isValidBST(root.left)) return false;
    	
    	if (!firstNode && root.val <= lastValue) return false;
    	firstNode = false;
    	lastValue = root.val;
    	
    	if (!isValidBST(root.right)) return false;
        
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
