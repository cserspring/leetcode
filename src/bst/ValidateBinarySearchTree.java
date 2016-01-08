package bst;

public class ValidateBinarySearchTree {

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, false, Integer.MIN_VALUE, false, Integer.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, boolean reachMin, int min, boolean reachMax, int max) {
    	if (root == null) return true;
    	int value = root.val;
    	if (value < min || value > max) return false;
    	
    	if (!reachMin && value == Integer.MIN_VALUE) {
    		if (root.left != null) return false;
    		return isValidBST(root.right, true, value, reachMax, max);    		
    	} else if (!reachMax && value == Integer.MAX_VALUE) {
    		if (root.right != null) return false;    		
    		return isValidBST(root.left, reachMin, min, true, value);
    	} else if (value > min && value < max) { 
    		return isValidBST(root.left, reachMin, min, reachMax, value) && 
    				isValidBST(root.right, reachMin, value, reachMax, max);    	
    	}
    	
    	return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
