package bst;

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class ConvertSortedListToBinarySearchTree {

    public TreeNode sortedListToBST(ListNode head) {
    	int[] nums = convertListToArray(head);
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
    
    private int[] convertListToArray(ListNode head) {
    	ListNode p = head;
    	int count = 0;
    	while (head != null) {
    		++count;
    		head = head.next;
    	}
    	
    	int[] nums = new int[count];
    	count = 0;
    	while (p != null) {
    		nums[count++] = p.val;
    		p = p.next;
    	}
    	
    	return nums;
    }
    
}
