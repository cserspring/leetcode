package bst;

import java.util.Stack;

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode(int x) { val = x; }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

public class BSTIterator {
	private Stack<TreeNode> stack;

    public BSTIterator(TreeNode root) {
    	stack = new Stack<TreeNode>();
    	TreeNode r = root;
    	while (r != null) {
    		stack.push(r);
    		r = r.left;
		}
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode node = stack.pop();
        TreeNode r = node.right;
        while (r != null) {
        	stack.push(r);
        	r = r.left;
        }
        
        return node.val;
    }
    
    public static void main(String[] args) {
    	TreeNode root = new TreeNode(7);
    	TreeNode node1 = new TreeNode(3);
    	TreeNode node2 = new TreeNode(4);
    	TreeNode node3 = new TreeNode(5);
    	TreeNode node4 = new TreeNode(6);
    	TreeNode node5 = new TreeNode(8);
    	TreeNode node6 = new TreeNode(9);
    	root.left=node1;
    	root.right=node6;
    	node1.right=node3;
    	node3.left=node2;
    	node3.right=node4;
    	node6.left=node5;
    	
    	BSTIterator i = new BSTIterator(root);
    	while (i.hasNext()) {
    		System.out.println(i.next());
    	}
    }
    
}

/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */
