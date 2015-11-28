package tree;

public class CountCompleteTreeNodes {

	private int isIdealCompleteTree(TreeNode root) {
		if (root == null) return 0;
		
		int h = 1;
		TreeNode left = root;
		TreeNode right = root;
		do {
			left = left.left;
			right = right.right;
			h = h << 1;
		} while (left != null && right != null);
		
		if (left != null || right != null)
			return -1;
		
		return h - 1;
	}
	
    public int countNodes(TreeNode root) {
        int cnt = isIdealCompleteTree(root);
        if (cnt != -1) return cnt; 
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
