package list;

public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = dummy.next;
        while (cur != null) {
        	if (cur.val == val) {
        		prev.next = cur.next;
        		cur = cur.next;
        	} else {
        		prev = cur;
        		cur = cur.next;
        	}
        }
        
        return dummy.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
