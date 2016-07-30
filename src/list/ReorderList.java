package list;

public class ReorderList {
    public void reorderList(ListNode head) {
    	if (head == null || head.next == null) return;
        ListNode mid = getMidNode(head);
        ListNode firstHalf = head;
        ListNode secondHalf = reverse(mid.next);
        mid.next = null;
        while (firstHalf != null && secondHalf != null) {
        	ListNode firstHalfNext = firstHalf.next;
        	ListNode secondHalfNext = secondHalf.next;
        	firstHalf.next = secondHalf;
        	secondHalf.next = firstHalfNext;
        	firstHalf = firstHalfNext;
        	secondHalf = secondHalfNext;
        }
    }

    private ListNode reverse(ListNode head) {
    	if (head == null || head.next == null) return head;
    	ListNode prev = null;
    	ListNode cur = head;
    	ListNode next;
    	while (cur != null) {
    		next = cur.next;
    		cur.next = prev;
    		prev = cur;
    		cur = next;
    	}
    	
    	return prev;
    }
    
    private ListNode getMidNode(ListNode head) {
    	ListNode slow = head;
    	ListNode fast = head;
    	while (fast != null && fast.next != null) {
    		slow = slow.next;
    		fast = fast.next.next;
    	}
    	
    	return slow;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
