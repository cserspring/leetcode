package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
    private class ListNode {
    	ListNode prev;
    	ListNode next;
    	int key;
    	int val;
    	ListNode (int key, int val) {
    		this.key = key;
    		this.val = val;
    		this.prev = null;
    		this.next = null;
    	}
    }
    
	private int capacity;
    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> dict;
    
	public LRUCache(int capacity) {
        this.capacity = capacity;
        this.head = new ListNode(-1, -1);
        this.tail = new ListNode(-1, -1);
        head.next = tail;
        tail.prev = head;
        this.dict = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if (!dict.containsKey(key)) return -1;
        ListNode curNode = dict.get(key);
        moveToTail(curNode, true);
        return curNode.val;
    }
    
    public void set(int key, int value) {
        if (!dict.containsKey(key)) {
        	ListNode newNode = new ListNode(key, value);
        	if (dict.size() == capacity) {
        		ListNode curNode = dict.get(head.next.key);
        		dict.remove(curNode.key);
        		head.next = curNode.next;
        		curNode.next.prev = curNode.prev;
        	}
        	
        	dict.put(key, newNode);
        	moveToTail(newNode, false);
        } else {
        	ListNode curNode = dict.get(key);
        	curNode.val = value;
        	moveToTail(curNode, true);
        }
    }
    
    private void moveToTail(ListNode node, boolean existed) {
    	if (existed) {
    		ListNode prev = node.prev;
    		ListNode next = node.next;
    		prev.next = next;
    		next.prev = prev;
    	}
    	
    	ListNode tailPrev = tail.prev;
    	tailPrev.next = node;
    	node.prev = tailPrev;
    	node.next = tail;
    	tail.prev = node;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRUCache cache = new LRUCache(2);
		cache.set(2,1);
		cache.set(1,1);
		System.out.println(cache.get(2));
		cache.set(4,1);
		System.out.println(cache.get(1));
		System.out.println(cache.get(2));
	}

}
