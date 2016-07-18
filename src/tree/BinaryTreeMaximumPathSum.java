package tree;

public class BinaryTreeMaximumPathSum {
    private int maxResult = Integer.MIN_VALUE;
    
	public int maxPathSum(TreeNode root) {
		helper(root);
		return this.maxResult;
    }
    
	private int helper(TreeNode root){
        if (root == null) return 0;
        int left = helper(root.left);
        int right = helper(root.right);
        /* retֵӦ�ð�����ǰ�ڵ㣬����ֻ������ѡ��һ�������������ѡ������parent׼��������ʱ���ǾͲ���single path��
        int ret = Math.max(root.val, Math.max(root.val + left, Math.max(root.val + right, root.val + left + right)));
        this.maxResult = Math.max(this.maxResult, ret);
        */
        int ret = Math.max(root.val, Math.max(root.val + left, root.val + right));
        this.maxResult = Math.max(this.maxResult, Math.max(ret, root.val + left + right));
        return ret;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		node1.left = node2;
		node1.right = node3;
		
		BinaryTreeMaximumPathSum b = new BinaryTreeMaximumPathSum();
		System.out.println(b.maxPathSum(node1));
	}

}
