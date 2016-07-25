package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class UndirectedGraphNode {
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x) { label = x; neighbors = new ArrayList<UndirectedGraphNode>(); }
};
 
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
    	if (node == null) return null;
        Map<Integer, UndirectedGraphNode> map = new HashMap<Integer, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        List<Integer> visited = new LinkedList<Integer>();
        queue.add(node);
        while (!queue.isEmpty()) {
        	UndirectedGraphNode curNode = queue.poll();
        	visited.add(curNode.label);        	
        	clone(curNode, map, queue, visited);
        }
        
        return map.get(node.label);
    }
    
    private void clone (UndirectedGraphNode curNode, Map<Integer, UndirectedGraphNode> map, Queue<UndirectedGraphNode> queue, List<Integer> visited) {
    	UndirectedGraphNode curNodeCpy;
    	if (map.containsKey(curNode.label)) {
    		curNodeCpy = map.get(curNode.label);
    	} else {
    		curNodeCpy= new UndirectedGraphNode(curNode.label);
    		map.put(curNodeCpy.label, curNodeCpy);
    	}
    	
    	List<UndirectedGraphNode> neighbors = curNode.neighbors;
    	for (UndirectedGraphNode neighbor : neighbors) {
    		if (!visited.contains(neighbor.label) && !queue.contains(neighbor)) queue.add(neighbor);
    		UndirectedGraphNode neighborCpy;
    		if (map.containsKey(neighbor.label)) {
    			neighborCpy = map.get(neighbor.label);
    		} else {
    			neighborCpy = new UndirectedGraphNode(neighbor.label);
    			map.put(neighborCpy.label, neighborCpy);
    		}
    		curNodeCpy.neighbors.add(neighborCpy);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
