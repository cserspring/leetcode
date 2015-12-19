package list;

public class MergeTwoSortedLists {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {        
        ListNode p = new ListNode(0);
        p.next = null;
        ListNode head = p;
        
        while (l1 != null && l2 != null) {
        	if (l1.val < l2.val) {
        		p.next = l1;
        		l1 = l1.next;
        	} else {
        		p.next = l2;
        		l2 = l2.next;
        	}
        	p = p.next;
        }
        
        p.next = l1 == null ? l2 : l1;
        return head.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
