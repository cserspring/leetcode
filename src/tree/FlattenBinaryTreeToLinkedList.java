package tree;

public class FlattenBinaryTreeToLinkedList {

    public void flatten(TreeNode root) {
        if (root == null) return;
        flatten(root.left);
        flatten(root.right);
        if (root.left != null) {
        	TreeNode tmp = root.right;
        	root.right = root.left;
        	root.left = null;
        	TreeNode rightMostNode = root;
        	while (rightMostNode.right != null) {
        		rightMostNode = rightMostNode.right;
        	}
        	rightMostNode.right = tmp;
        }
    }

}
