package list;

public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode p = new ListNode(0);
        ListNode node = p;
        int sum = 0;
        int carry = 0;
        while (true) {
        	if (l1 != null && l2 != null) {
        		sum = l1.val + l2.val + carry;
        		l1 = l1.next;
        		l2 = l2.next;
        	} else if (l1 != null) {
        		sum = l1.val + carry;
        		l1 = l1.next;
        	} else if (l2 != null){
        		sum = l2.val + carry;
        		l2 = l2.next;
        	} else {
        		sum = carry;
        		if (sum == 0)
        			break;
        	}
        	
        	p.next = new ListNode(sum % 10);
    		carry = sum / 10;
        	p = p.next;
        }
        
        return node.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
