package tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeRightSideView {
	
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        List<List<Integer>> levelTraversalResult = new ArrayList<List<Integer>>();
        levelTraversal(levelTraversalResult, root, 1);
        for (int i = 0; i < levelTraversalResult.size(); ++i) {
        	result.add(levelTraversalResult.get(i).get(levelTraversalResult.get(i).size() - 1));
        }
        
        return result;
    }
    
    private void levelTraversal(List<List<Integer>> levelTraversalResult, TreeNode root, int level) {
    	if (root == null) return;
    	if (levelTraversalResult.size() < level) {
    		List<Integer> curLevelResult = new ArrayList<Integer>();
    		curLevelResult.add(root.val);
    		levelTraversalResult.add(curLevelResult);
    	} else {
    		levelTraversalResult.get(level - 1).add(root.val);
    	}
    	
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
