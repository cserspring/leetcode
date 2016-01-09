package treetraversal;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeLevelOrderTraversal {

    public List<List<Integer>> levelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	//List<Integer> record = new ArrayList<Integer>();
    	levelOrderTraversal(res, root, 0);
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
