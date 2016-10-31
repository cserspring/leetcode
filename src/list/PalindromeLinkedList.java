package list;

public class PalindromeLinkedList {
	// http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
	// Solution 1: Reverse the second half
	// Solution 2: Recursive
	private ListNode left;
	
    public boolean isPalindrome(ListNode head) {
    	left = head;
    	return helper(head);
    }
    
    private boolean helper(ListNode right) {
    	if (right == null) return true;
    	if (!helper(right.next)) return false;
    	boolean res = (left.val == right.val);
    	left = left.next;
    	return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
