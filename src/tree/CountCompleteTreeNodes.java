package tree;

public class CountCompleteTreeNodes {

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
