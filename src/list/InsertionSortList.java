package list;

public class InsertionSortList {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode fakeHead = new ListNode(-1);
        
        while (head != null) {
        	ListNode next = head.next; // Make a copy of the next node.
        	insert(fakeHead, head);
        	head = next;
        }
        
        return fakeHead.next;
    }
    
    // Insert a new node into a sorted list
    private void insert(ListNode fakeHead, ListNode newNode) {
    	// Use node.next to write concise code
    	ListNode node = fakeHead;
    	while (node.next != null && node.next.val < newNode.val) {
    		node = node.next;
    	}
    	
    	newNode.next = node.next;
    	node.next = newNode;
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
