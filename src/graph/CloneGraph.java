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
        Map<UndirectedGraphNode, UndirectedGraphNode> createdNodes = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
        Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
        queue.add(node);
        UndirectedGraphNode nodeCpy = new UndirectedGraphNode(node.label);
        createdNodes.put(node, nodeCpy);
        while (!queue.isEmpty()) {
        	UndirectedGraphNode curNode = queue.poll();
        	UndirectedGraphNode curNodeCpy = createdNodes.get(curNode);
        	List<UndirectedGraphNode> neighbors = curNode.neighbors;
        	for (UndirectedGraphNode neighbor : neighbors) {
        		UndirectedGraphNode neighborCpy;
        		if (createdNodes.containsKey(neighbor)) {
        			neighborCpy = createdNodes.get(neighbor);
        		} else {
        			neighborCpy = new UndirectedGraphNode(neighbor.label);
        			createdNodes.put(neighbor, neighborCpy);
        			queue.add(neighbor);
        		}
        		
        		curNodeCpy.neighbors.add(neighborCpy);
        	}
        }
        
        return createdNodes.get(node);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
