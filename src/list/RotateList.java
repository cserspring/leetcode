package list;

public class RotateList {

    public ListNode rotateRight(ListNode head, int k) {
    	if (k == 0 || head == null) return head;
    	
        ListNode x = head;
        int count = 0;
        while (x != null) {
        	++count;
        	x = x.next;
        }
        
        int n = k;
        if (k >= count) {
        	if (k % count == 0)
        		return head;
        	else
        		n = k % count;
        }
        	
        ListNode p = head;
        ListNode q = head;
        while (p != null && n > 0) {
        	p = p.next;
        	--n;
        }
        
        while (p.next != null && q.next != null) {
        	p = p.next;
        	q = q.next;
        }
        
        ListNode newhead = q.next;
        p.next = head;
        q.next = null;
        return newhead;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RotateList r = new RotateList();
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
		ListNode head = r.rotateRight(a1, 2);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
