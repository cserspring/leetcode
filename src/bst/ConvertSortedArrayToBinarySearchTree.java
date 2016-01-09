package bst;

public class ConvertSortedArrayToBinarySearchTree {

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructBST(nums, 0, nums.length - 1);
    }

    private TreeNode constructBST(int[] nums, int start, int end) {
    	if (start > end) return null;
    	int mid = (end - start) / 2 + start;
    	TreeNode root = new TreeNode(nums[mid]);
    	root.left = constructBST(nums, start, mid - 1);
    	root.right = constructBST(nums, mid + 1, end);
    	return root;
    }
    
}
