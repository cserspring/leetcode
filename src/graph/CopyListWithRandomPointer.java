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
    		RandomListNode nodeCpy = getNodeCpy(map, node);
    		
    		RandomListNode next = node.next;
    		RandomListNode random = node.random;    		
    		if (next != null) 
    			nodeCpy.next = getNodeCpy(map, next);    		
			
    		if (random != null) 
				nodeCpy.random = getNodeCpy(map, random);
				    		
    		node = next;
    	}
    	
    	return map.get(head);
    }
    
    private RandomListNode getNodeCpy(HashMap<RandomListNode, RandomListNode> map, RandomListNode node) {
    	RandomListNode nodeCpy;
    	if (map.containsKey(node)) {
    		nodeCpy = map.get(node);
    	} else {
    		nodeCpy = new RandomListNode(node.label);
    		map.put(node, nodeCpy);
    	}
    	
    	return nodeCpy;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
