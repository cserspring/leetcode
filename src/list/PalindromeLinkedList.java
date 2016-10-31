package list;

public class PalindromeLinkedList {
	// http://www.programcreek.com/2014/07/leetcode-palindrome-linked-list-java/
	// Solution 1: Reverse the second half
	// Solution 2: Recursive
    public boolean isPalindrome(ListNode head) {
    	if (head == null) return true;
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        ListNode secondHead = reverse(slow.next);
        slow.next = null;
        while (head != null && secondHead != null) {
        	if (head.val != secondHead.val)
        		return false;
        	head = head.next;
        	secondHead = secondHead.next;
        }
        
        return true;
    }
    
    private ListNode reverse(ListNode head) {
    	ListNode prev = null;
    	while (head != null) {
    		ListNode next = head.next;
    		head.next = prev;
    		prev = head;
    		head = next;
    	}
    	
    	return prev;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
