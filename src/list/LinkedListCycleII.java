package list;

public class LinkedListCycleII {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        	if (p1 == p2) {
        		p1 = head;
        		while (p1 != p2) {
        			p1 = p1.next;
        			p2 = p2.next;
        		}
        		
        		return p1;
        	}
        }
        
        return null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
