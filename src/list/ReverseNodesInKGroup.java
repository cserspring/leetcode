package list;

public class ReverseNodesInKGroup {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k < 2) return head;
        ListNode first = new ListNode(0);
        first.next = head;
        
        ListNode prevp = first;
        ListNode p = head;
        ListNode q = p;

        while (q != null) {
            int i = 0;
        	for (; q != null && i < k - 1; ++i) {
        		q = q.next;
        	}
        	
        	if (i == k - 1 && q != null) {
        		ListNode qNext = q.next;
        		q.next = null;
        		ListNode newHead = reverseList(p);
        		prevp.next = newHead;
        		prevp = p;
        		p = qNext;
        		q = qNext;
        		prevp.next = qNext;
        	} 
        }
                
        return first.next;
    }
    
    // This function will only be invoked when the list contains more than one node.
    private ListNode reverseList(ListNode head) {
    	ListNode prevp = null;
    	ListNode p = head;
    	ListNode q = head.next;
    	while (p != null && q != null) {
    		ListNode tmp = q.next;
    		q.next = p;
    		p.next = prevp;
    		prevp = p;
    		p = q;
    		q = tmp;
    	}
    	
    	return p;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = null;
		
		ReverseNodesInKGroup r = new ReverseNodesInKGroup();
		ListNode x = r.reverseKGroup(a1, 3);
		while (x != null) {
			System.out.println(x.val);
			x = x.next;
		}
	}

}
