package bst;

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
        List<TreeNode> res = new ArrayList<TreeNode>();
        if (n <= 0) return res;
        return generateTrees(1, n);
    }
    
    private List<TreeNode> generateTrees(int left, int right) {
    	List<TreeNode> roots = new ArrayList<TreeNode>();
    	if (left > right || left <= 0 || right <= 0) {
    		roots.add(null);
    	} else if (left == right) {
    		TreeNode root = new TreeNode(left);
    		roots.add(root);
    	} else {
    		for (int i = left; i <= right; ++i) {
    			List<TreeNode> leftTree = generateTrees(left, i - 1);
    			List<TreeNode> rightTree = generateTrees(i + 1, right);
    			for (int j = 0; j < leftTree.size(); ++j) {
    				for (int k = 0; k < rightTree.size(); ++k) {
    					TreeNode root = new TreeNode(i);
    					root.left = leftTree.get(j);
    					root.right = rightTree.get(k);
    					roots.add(root);
    				}
    			}
    		}
    	}
    	
    	return roots;    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueBinarySearchTreesII u = new UniqueBinarySearchTreesII();
		u.generateTrees(3);
	}

}
