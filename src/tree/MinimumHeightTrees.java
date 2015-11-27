package tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class MinimumHeightTrees {
	// We remove the leaves one step by one step, so there will be at most 2 vertices at last.
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {         
    	if (n == 1) return Collections.singletonList(0);
    	
    	ArrayList<HashSet<Integer>> adjacencyLists = new ArrayList<HashSet<Integer>>(n);
        for (int i = 0; i < n; ++i) {
        	adjacencyLists.add(new HashSet<Integer>());
        }
        
        for (int[] edge : edges) {
        	adjacencyLists.get(edge[0]).add(edge[1]);
        	adjacencyLists.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < n; ++i) {
        	if (adjacencyLists.get(i).size() == 1)
        		result.add(i);
        }

        while (n > 2) {
			n = n - result.size();
			List<Integer> newResult = new ArrayList<Integer>();
			for (int i : result) {
				int label = adjacencyLists.get(i).iterator().next();
				adjacencyLists.get(label).remove(i);
				if (adjacencyLists.get(label).size() == 1)
					newResult.add(label);
			}

        	result = newResult;
        }
        
        return result;
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
