package list;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class IntersectionOfTwoLinkedLists {
	
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        int m = 0;
        ListNode a = headA;
        int n = 0;
        ListNode b = headB;
        while (a != null) {
        	m++;
        	a = a.next;
        }
        
        while (b != null) {
        	n++;
        	b = b.next;
        }
        
        int delta = m - n;
        return delta > 0 ? getIntersectionNode(headA, headB, delta) : getIntersectionNode(headB, headA, -delta);
    }
    
    private ListNode getIntersectionNode(ListNode headA, ListNode headB, int delta) {
    	for (int i = 0; i < delta; ++i)
    		headA = headA.next;
    	while (headA != null && headB != null) {
    		if (headA == headB)
    			return headA;
    		headA = headA.next;
    		headB = headB.next;
    	}
    	
    	return headA;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode b1 = new ListNode(2);
		ListNode c1 = new ListNode(3);
		ListNode c2 = new ListNode(4);
		
		a1.next = c1;
		b1.next = c1;
		c1.next=c2;
		
		IntersectionOfTwoLinkedLists inter = new IntersectionOfTwoLinkedLists();
		System.out.println(inter.getIntersectionNode(a1, b1).val);
	}

}
