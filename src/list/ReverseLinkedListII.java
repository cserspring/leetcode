package list;

public class ReverseLinkedListII {

    public ListNode reverseBetween(ListNode head, int m, int n) {
    	if (m == n) return head;
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode firstPivot = null;
        ListNode firstPivotNext = null;
        ListNode prev = p;
        ListNode node = head;
        int i = 1;
        while (i <= n) {
        	if (i > m && i < n) {
        		ListNode tmp = node;
        		node = node.next;
        		tmp.next = prev;
        		prev = tmp;
        	} else if (i < m) {
        		node = node.next;
        		prev = prev.next;
        	} else if (i == m) {
        		firstPivot = prev;
        		firstPivotNext = node;
        		ListNode tmp = node;
        		node = node.next;
        		tmp.next = null;
        		prev = tmp;
        	} else if (i == n) {
        		ListNode tmp = node;
        		node = node.next;
        		tmp.next = prev;
        		firstPivot.next = tmp;
        		firstPivotNext.next = node;
        	}
        	++i;        	
        }
        return p.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = null;
		ReverseLinkedListII r = new ReverseLinkedListII();
		ListNode head = r.reverseBetween(a1, 2, 5);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
