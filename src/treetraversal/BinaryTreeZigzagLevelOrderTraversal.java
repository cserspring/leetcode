package treetraversal;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTreeZigzagLevelOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	//List<Integer> record = new ArrayList<Integer>();
    	levelOrderTraversal(res, root, 0);
    	for (int i = 0; i < res.size(); ++i) {
    		if (i % 2 == 1) {
    			Collections.reverse(res.get(i));
    		}
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
