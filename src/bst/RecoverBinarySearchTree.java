package bst;

public class RecoverBinarySearchTree {
    
	private TreeNode prev = null;
    
	private TreeNode node1 = null;
    
	private TreeNode node2 = null;
    
    public void recoverTree(TreeNode root) {
    	recoverTreeInternal(root);
        swap(node1, node2);
    }
    
    private void recoverTreeInternal(TreeNode root) {
    	if (root == null) return;
    	recoverTreeInternal(root.left);
    	if (prev != null) {
    		if (prev.val >= root.val) {
    			if (node1 == null) 
    				node1 = prev;
    			node2 = root;
    		}
    	}
    	
    	prev = root;
    	recoverTreeInternal(root.right);    	
    }
    
    private void swap(TreeNode node1, TreeNode node2) {
    	if (node1 != null && node2 != null) {
    		int tmp = node1.val;
    		node1.val = node2.val;
    		node2.val = tmp;
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RecoverBinarySearchTree r = new RecoverBinarySearchTree();
		TreeNode root = new TreeNode(0);
		TreeNode right = new TreeNode(1);
		root.left = right;
		r.recoverTree(root);
	}

}
