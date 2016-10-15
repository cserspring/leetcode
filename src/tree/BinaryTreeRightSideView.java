package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BinaryTreeRightSideView {
	/* We don't need to use List<List<Integer>> levelTraversalResult to store the level traversal result.
	 * Just use a HashMap to store the last result.
	 * */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Map<Integer, Integer> levelTraversalResult = new HashMap<Integer, Integer>();
        levelTraversal(levelTraversalResult, root, 0);
        for (int i = 0; i < levelTraversalResult.size(); ++i) {
        	result.add(levelTraversalResult.get(i));
        }
        return result;
    }
    
    private void levelTraversal(Map<Integer, Integer> levelTraversalResult, TreeNode root, int level) {
    	if (root == null) return;
    	levelTraversalResult.put(level, root.val);
    	levelTraversal(levelTraversalResult, root.left, level + 1);
    	levelTraversal(levelTraversalResult, root.right, level + 1);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode node1 = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		node1.left = node2;
		node1.right = node3;
		node2.right = node4;
		node3.right = node5;
		node4.left = node6;
		
		BinaryTreeRightSideView b = new BinaryTreeRightSideView();		
		List<Integer> res = b.rightSideView(node1);
		for (int i : res) {
			System.out.println(i);
		}
	}

}
