package list;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        ListNode p1 = head;
        ListNode p2 = head;
        while (p1 != null && p2 != null) {
        	p1 = p1.next;
        	if (p2.next != null) 
        		p2 = p2.next.next;
        	else
        		return false;
        	if (p1 == p2)
        		return true;
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
