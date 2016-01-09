package tree;

import java.util.ArrayList;
import java.util.List;

public class PathSumII {
	
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if (root == null) return res;
    	List<Integer> record = new ArrayList<Integer>();
    	pathSum(res, record, root, sum);
    	return res;
    }
    
    private void pathSum(List<List<Integer>> res, List<Integer> record, TreeNode root, int sum) {
    	if (root == null && sum != 0) return;
    	if (root == null && sum == 0) {
    		res.add(record);
    	} else {
    		if (root.left == null || root.right == null) {
        		List<Integer> newRecord = new ArrayList<Integer>(record);
        		newRecord.add(root.val);
        		pathSum(res, newRecord, root.left == null ? root.right : root.left, sum - root.val);
    		} else {
    			List<Integer> newRecord1 = new ArrayList<Integer>(record);
    			newRecord1.add(root.val);
    			pathSum(res, newRecord1, root.left, sum - root.val);
    			List<Integer> newRecord2 = new ArrayList<Integer>(record);
    			newRecord2.add(root.val);
    			pathSum(res, newRecord2, root.right, sum - root.val);
    		}
    	}
    }
    
}
