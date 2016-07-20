package tree;

public class SumRootToLeafNumbers {
	private int result;
	
    public int sumNumbers(TreeNode root) {
    	this.result = 0;
    	calculate(root, 0);
    	return this.result;
    }
    
    private void calculate(TreeNode root, int prev) {
    	if (root != null) {
    		if (root.left == null && root.right == null) {
    			this.result += prev*10 + root.val;
    		} else {    		
    			calculate(root.left, prev*10 + root.val);
    			calculate(root.right, prev*10 + root.val);
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
