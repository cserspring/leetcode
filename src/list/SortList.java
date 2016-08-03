package list;

public class SortList {
	public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode mid = getMiddleNode(head);
        ListNode secondHead = mid.next;
        mid.next = null; // Set it to NULL
        return merge(sortList(head), sortList(secondHead));
    }
	
	private ListNode merge(ListNode p, ListNode q) {
		ListNode fakeHead = new ListNode(-1);
		ListNode node = fakeHead;
		while (p != null && q != null) {
			if (p.val < q.val) {
				node.next = p;
				p = p.next;
			} else {
				node.next = q;
				q = q.next;
			}
			
			node = node.next;
		}
		
		if (p == null) 
			node.next = q;
		if (q == null)
			node.next = p;
		
		return fakeHead.next;
	}

	private ListNode getMiddleNode (ListNode head) {
		ListNode slow = head;
		ListNode fast = head;
		// Use fast.next != null && fast.next.next != null here
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		
		return slow;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(4);
		node1.next = node2;
		node2.next = node3;
		SortList s = new SortList();
		ListNode p = s.sortList(node1);
		while (p != null) {
			System.out.println(p.val);
			p = p.next;
		}
	}

}
