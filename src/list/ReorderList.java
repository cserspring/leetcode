package list;

import java.util.HashMap;
import java.util.Map;

public class ReorderList {
    public void reorderList(ListNode head) {
        Map<Integer, ListNode> dict = new HashMap<Integer, ListNode>();
        ListNode p = head;
        int n = 0;
        while (p != null) {
        	dict.put(n, p);
        	++n;
        	p = p.next;
        }
        
        if (n <= 2) return;
        int mid = n/2;
        int i = 0;
        p = head;
        while (i < mid) {
        	ListNode next = p.next;
        	p.next = dict.get(n - 1 - i);
        	p.next.next = next;
        	p = next;
        	++i;
        }
        
        dict.get(i).next = null;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
