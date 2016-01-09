package treetraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversalII {
	
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	levelOrderTraversal(res, root, 0);
    	int n = res.size();
    	for (int i = 0; i < n / 2; ++i) {
    		List<Integer> tmp = res.get(i);
    		res.set(i, res.get(n - i - 1));
    		res.set(n - i - 1, tmp);
    	}
    	return res;
    }
    
    private void levelOrderTraversal(List<List<Integer>> res, TreeNode root, int k) {
    	if (root == null) return;
    	if (res.size() < k + 1) {
    		List<Integer> record = new ArrayList<Integer>();
    		record.add(root.val);
    		res.add(record);
    	} else {
    		res.get(k).add(root.val);
    	}
    	levelOrderTraversal(res, root.left, k + 1);
    	levelOrderTraversal(res, root.right, k + 1);
    }
    
}
