package list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
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
