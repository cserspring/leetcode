package list;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
    	int len;
        if (lists == null || (len = lists.length) == 0) return null;
        
        int cur = 0;
        int end = len - 1;
        while (end > 0) {
        	cur = 0;
        	while (cur < end) {
        		lists[cur] = mergeTwoLists(lists[cur], lists[end]);
        		++cur;
        		--end;
        	}
        }
        	        
        return lists[0];
    }
    
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
