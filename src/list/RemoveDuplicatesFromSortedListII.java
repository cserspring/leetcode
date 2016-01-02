package list;

public class RemoveDuplicatesFromSortedListII {
    
	public ListNode deleteDuplicates(ListNode head) {
        ListNode p = new ListNode(0);
        p.next = null;
        ListNode prev = p;
        
        ListNode q = head;
        while (head != null) {
        	while (q.next != null && q.next.val == head.val)
        		q = q.next;
        	if (q == head) {
        		prev.next = head;
        		prev = prev.next;
        	}
        	
        	head = q.next;
        	q = head;
        }
        
        prev.next = null;
        return p.next;
    }
    
	public static void main(String[] args) {
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(2);
		ListNode a4 = new ListNode(3);
		ListNode a5 = new ListNode(4);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = null;
		RemoveDuplicatesFromSortedListII r = new RemoveDuplicatesFromSortedListII();
		ListNode head = r.deleteDuplicates(a1);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
