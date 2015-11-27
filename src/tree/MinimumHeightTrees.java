package tree;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class MinimumHeightTrees {

    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
    	int x;
        if (edges == null || (x = edges.length) == 0) return null;
        if (edges[0] == null || edges[0].length == 0) return null;
                
    	ArrayList<ArrayList<Integer>> adjacencyLists = new ArrayList<ArrayList<Integer>>(n);
        for (int i = 0; i < n; ++i) {
        	adjacencyLists.add(new ArrayList<Integer>());
        }
        
        for (int i = 0; i < x; ++i) {
        	adjacencyLists.get(edges[i][0]).add(edges[i][1]);
        	adjacencyLists.get(edges[i][1]).add(edges[i][0]);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        int minHeight = Integer.MAX_VALUE;
        for (int i = 0; i < n; ++i) {
        	HashSet<Integer> visited = new HashSet<Integer>();
        	int value = heightBasedOnVertex(i, adjacencyLists, visited);
        	if (value == minHeight) {
        		result.add(i);
        	} else if (value < minHeight) {
        		result.clear();
        		result.add(i);
        		minHeight = value;
        	}
        }
        
        return result;
    }
    
    private int heightBasedOnVertex(int label, ArrayList<ArrayList<Integer>> adjacencyLists, HashSet<Integer> visited) {
    	if (visited.contains(label))
    		return 0;
    	int max = 0;
   		visited.add(label);
   		for (int i : adjacencyLists.get(label)) {
   			int value = heightBasedOnVertex(i, adjacencyLists, visited);
   			if (value > max) {
   				max = value;
   			}
   		}
   		return max + 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MinimumHeightTrees m = new MinimumHeightTrees();
		int n = 6;
		int[][] edges = {{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
		for (int i : m.findMinHeightTrees(n, edges))
			System.out.println(i);
	}

}
