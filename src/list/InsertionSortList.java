package list;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(-1);
        // Below initialization should be careful.
        fakeHead.next = head;
        ListNode node = head.next;
        head.next = null;
        
        while (node != null) {
        	ListNode next = node.next; // Make a copy of the next node.
        	insert(fakeHead, node);
        	node = next;
        }
        
        return fakeHead.next;
    }
    
    // Insert a new node into a sorted list
    private void insert(ListNode fakeHead, ListNode newNode) {
    	ListNode prev = fakeHead;
    	ListNode cur = fakeHead.next; // We already put head into this list, so cur will not be null
    	while (cur != null) {
    		if (newNode.val <= cur.val) {
    			prev.next = newNode;
    			newNode.next = cur;
    			return;
    		} else {
    			prev = cur;
    			cur = cur.next;
    		}
    	}
    	
    	prev.next = newNode;
    	newNode.next = null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode head = new ListNode(1);
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		head.next = node2;
		node2.next = node1;
		InsertionSortList i = new InsertionSortList();
		head = i.insertionSortList(head);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
