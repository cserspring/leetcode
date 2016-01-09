package treetraversal;

public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return construct(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode construct(int[] preorder, int pstart, int pend, int[] inorder, int istart, int iend) {
    	if (pstart > pend || istart > iend) return null;
    	int rootVal = preorder[pstart];
    	int index = -1;
    	for (int i = istart; i <= iend; ++i) {
    		if (inorder[i] == rootVal) {
    			index = i;
    			break;
    		}
    	}
    	
    	TreeNode root = new TreeNode(rootVal);    	
    	root.left = construct(preorder, pstart + 1, index - istart + pstart, inorder, istart, index - 1);
    	root.right = construct(preorder, index - istart + pstart + 1, pend, inorder, index + 1, iend);
    	return root;
    }
    
}
