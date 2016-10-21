package list;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
    	ListNode prev = head;
    	ListNode cur = null;
    	if (head != null) {
    		cur = head.next;
    		prev.next = null;
    	}
        while (cur != null) {
        	ListNode next = cur.next;
        	cur.next = prev;
        	prev = cur;
        	cur = next;
        }
        
        return prev;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
