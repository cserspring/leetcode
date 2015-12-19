package list;

public class RemoveNthNodeFromEndOfList {

    public ListNode removeNthFromEnd(ListNode head, int n) {
    	ListNode p1 = head;
    	ListNode p2 = head;
    	ListNode prevp2 = new ListNode(0);
    	prevp2.next = p2;
    	head = prevp2;
    	while (--n > 0) {
    		p1 = p1.next;
    	}
    	
    	while (p1.next != null) {
    		p1 = p1.next;
    		prevp2 = p2;
    		p2 = p2.next;
    	}
    	
    	prevp2.next = p2.next;
        return head.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
