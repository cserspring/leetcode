package list;

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
    	if (head == null || head.next == null) return false;
    	
        ListNode p1 = head;
        ListNode p2 = head;
        while (p2.next != null && p2.next.next != null) {
        	p1 = p1.next;
        	p2 = p2.next.next;
        	if (p1 == p2)
        		return true;
        }
        
        return false;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
