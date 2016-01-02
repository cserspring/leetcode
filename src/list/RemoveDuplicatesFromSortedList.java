package list;

public class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
    	ListNode p = head;
        ListNode start = head;
        while (head != null && head.next != null) {
        	ListNode headNext = head.next;
        	if (head.next.val != head.val) {
        		start = head.next;
        	} else {
        		start.next = head.next.next;
        	}
        	
        	head = headNext;
        }
        return p;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(1);
		ListNode a3 = new ListNode(1);
		ListNode a4 = new ListNode(1);
		ListNode a5 = new ListNode(1);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = null;
		RemoveDuplicatesFromSortedList r = new RemoveDuplicatesFromSortedList();
		ListNode head = r.deleteDuplicates(a1);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
