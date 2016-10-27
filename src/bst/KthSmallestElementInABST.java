package bst;

public class KthSmallestElementInABST {
	private int count;
	private int res;
    public int kthSmallest(TreeNode root, int k) {
    	count = 0;
        dfs(root, k);
        return res;
    }
    
    private void dfs(TreeNode root, int k) {
    	if (root != null) {
    		dfs(root.left, k);
    		if (++count == k) {
    			res = root.val;
    			return;
    		}
    		dfs(root.right, k);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
    	TreeNode root = new TreeNode(7);
    	TreeNode node1 = new TreeNode(3);
    	TreeNode node2 = new TreeNode(4);
    	TreeNode node3 = new TreeNode(5);
    	TreeNode node4 = new TreeNode(6);
    	TreeNode node5 = new TreeNode(8);
    	TreeNode node6 = new TreeNode(9);
    	root.left=node1;
    	root.right=node6;
    	node1.right=node3;
    	node3.left=node2;
    	node3.right=node4;
    	node6.left=node5;
    	KthSmallestElementInABST k = new KthSmallestElementInABST();
    	for (int i = 1; i <= 7; ++i)
    		System.out.println(k.kthSmallest(root,i));
	}

}
