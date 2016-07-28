package graph;

import java.util.HashMap;

//Definition for singly-linked list with a random pointer.
class RandomListNode {
	int label;
	RandomListNode next, random;
	RandomListNode(int x) { this.label = x; }
}
 
public class CopyListWithRandomPointer {
    public RandomListNode copyRandomList(RandomListNode head) {
    	if (head == null) return null;
    	HashMap<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
    	RandomListNode node = head;
    	
    	while (node != null) {
    		RandomListNode nodeCpy;
    		if (!map.containsKey(node)) {
    			nodeCpy = new RandomListNode(node.label);
    	    	map.put(node, nodeCpy);
    		} else {
    			nodeCpy = map.get(node);
    		}
    		
    		RandomListNode next = node.next;
    		RandomListNode random = node.random;
    		
    		if (next != null) {
    			if (map.containsKey(next)) {
    				nodeCpy.next = map.get(next);
    			} else {
    				RandomListNode nextCpy = new RandomListNode(next.label);
    				nodeCpy.next = nextCpy;
    				map.put(next, nextCpy);
    			}
    		}
			
    		if (random != null) {
				if (map.containsKey(random)) {
					nodeCpy.random = map.get(random);
				} else {
					RandomListNode randomCpy = new RandomListNode(random.label);
					nodeCpy.random = randomCpy;
					map.put(random, randomCpy);
				}
			}		
    		
    		node = next;
    	}
    	
    	return map.get(head);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
