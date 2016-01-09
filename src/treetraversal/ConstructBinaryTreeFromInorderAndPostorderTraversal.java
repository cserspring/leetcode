package treetraversal;

public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	return construct(postorder, 0, postorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode construct(int[] postorder, int pstart, int pend, int[] inorder, int istart, int iend) {
    	if (pstart > pend || istart > iend) return null;
    	int rootVal = postorder[pend];
    	int index = -1;
    	for (int i = istart; i <= iend; ++i) {
    		if (inorder[i] == rootVal) {
    			index = i;
    			break;
    		}
    	}
    	
    	TreeNode root = new TreeNode(rootVal);    	
    	root.left = construct(postorder, pstart, pstart + index - istart - 1, inorder, istart, index - 1);
    	root.right = construct(postorder, pstart + index - istart, pend - 1, inorder, index + 1, iend);
    	return root;
    }
    
}
