package divideconquer;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

public class UniqueBinarySearchTreesII {

    public List<TreeNode> generateTrees(int n) {
    	if (n <= 0) return new ArrayList<TreeNode>();
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int left, int right) {
    	List<TreeNode> roots = new ArrayList<TreeNode>();
    	if (left > right) {
    		roots.add(null);
    		return roots;
    	}
    	
    	for (int i = left; i <= right; ++i) {
    		List<TreeNode> leftTree = generateTrees(left, i - 1);
    		List<TreeNode> rightTree = generateTrees(i + 1, right);
    		for (int m = 0; m < leftTree.size(); ++m) {
    			for (int n = 0; n < rightTree.size(); ++n) {
    				TreeNode root = new TreeNode(i);
    				root.left = leftTree.get(m);
    				root.right = rightTree.get(n);
    				roots.add(root);
    			}
    		}
    	}
    	
    	return roots;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
		/*List<TreeNode> nodes = */u.generateTrees(3);
	}

}
