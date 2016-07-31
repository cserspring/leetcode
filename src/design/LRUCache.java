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
    
    private int count;
	private int capacity;
    private ListNode head;
    private ListNode tail;
    private Map<Integer, ListNode> dict;
    
	public LRUCache(int capacity) {
		this.count = 0;
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
        this.dict = new HashMap<Integer, ListNode>();
    }
    
    public int get(int key) {
        if (!dict.containsKey(key)) return -1;
        ListNode curNode = dict.get(key);
        if (tail == curNode) return curNode.val;
        if (head == curNode) {
        	head = curNode.next;
        	head.prev = null;
        } else {
            ListNode prevNode = curNode.prev;
            ListNode nextNode = curNode.next;
            if (prevNode != null)
            	prevNode.next = nextNode;
            if (nextNode != null)
            	nextNode.prev = prevNode;        	
        }        

        tail.next = curNode;
        curNode.prev = tail;
        tail = curNode;
        return curNode.val;
    }
    
    public void set(int key, int value) {
        if (!dict.containsKey(key)) {
        	if (count >= capacity) {
        		// remove the head
        		dict.remove(head.key);
        		--count;
        		head = head.next;
        		if (head != null)
        			head.prev = null;        		
        	}
        	
        	ListNode node = new ListNode(key, value);
        	dict.put(key, node);
        	++count;
        	if (head == null) {
        		head = node;
        		tail = node;
        	} else {
        		tail.next = node;
        		node.prev = tail;
        		tail = node;
        	}
        } else {
        	ListNode curNode = dict.get(key);
        	curNode.val = value;
            if (tail == curNode) return;
            if (head == curNode) {
            	head = curNode.next;
            	head.prev = null;
            } else {
                ListNode prevNode = curNode.prev;
                ListNode nextNode = curNode.next;
                if (prevNode != null)
                	prevNode.next = nextNode;
                if (nextNode != null)
                	nextNode.prev = prevNode;        	
            }        

            tail.next = curNode;
            curNode.prev = tail;
            tail = curNode;
        }
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
