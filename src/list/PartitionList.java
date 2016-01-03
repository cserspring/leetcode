package list;

public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode leftNode = new ListNode(0);
        ListNode rightNode = new ListNode(0);
        ListNode p = leftNode;
        ListNode q = rightNode;
        while (head != null) {
        	if (head.val < x) {
        		leftNode.next = head;
        		leftNode = leftNode.next;
        	} else {
        		rightNode.next = head;
        		rightNode = rightNode.next;
        	}
        	head = head.next;
        }
        rightNode.next = null;
        leftNode.next = q.next;
        return p.next;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(4);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(2);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(2);
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		a6.next = null;
		PartitionList p = new PartitionList();
		ListNode head = p.partition(a1, 3);
		while (head != null) {
			System.out.println(head.val);
			head = head.next;
		}
	}

}
