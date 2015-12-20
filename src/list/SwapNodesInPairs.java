package list;

public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {
    	ListNode x = new ListNode(0);
        x.next = head;
    	ListNode y = head;
        ListNode z = null;

        ListNode first = x;
        
        while (y != null && y.next != null) {
        	z = y.next;
        	ListNode tmp = z.next;
        	x.next = z;
        	z.next = y;
        	y.next = tmp;
        	
        	x = y;
        	y = tmp;
        }
        
        return first.next; 
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
		
		SwapNodesInPairs s = new SwapNodesInPairs();		
		ListNode x = s.swapPairs(a1);
		while (x != null) {
			System.out.println(x.val);
			x = x.next;
		}
	}

}
