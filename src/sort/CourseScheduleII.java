package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseScheduleII {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
    	// 0. Create adjacent lists, which are used when recalculate the indegree.
    	List<List<Integer>> adjLists = new ArrayList<List<Integer>>(numCourses);
    	for (int i = 0; i < numCourses; ++i)
    		adjLists.add(new ArrayList<Integer>());
    	for (int i = 0; i < prerequisites.length; ++i) {
    		adjLists.get(prerequisites[i][1]).add(prerequisites[i][0]);
    	}
    	// 1. Calculate the indgree of every node.
        int[] indegree = new int[numCourses];
        for (int i = 0; i < prerequisites.length; ++i) {
        	++indegree[prerequisites[i][0]];
        }
        
        int count = 0;
        int[] res = new int[numCourses];
        // 2. Initialize the queue, which contains the nodes whose indegree is 0.
        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < numCourses; ++i) {
        	if (indegree[i] == 0)
        		queue.add(i);
        }
        
        while (!queue.isEmpty()) {
        	int node = queue.poll();
        	res[count++] = node;
        	// 3. Remove the node, recaculate the indegree of corresponding nodes.
        	for (int i = 0; i < adjLists.get(node).size(); ++i) {
        		if (--indegree[adjLists.get(node).get(i)] == 0)
        			queue.add(adjLists.get(node).get(i));
        	}
        }
        
        for (int i = 0; i < numCourses; ++i) {
        	if (indegree[i] > 0)
        		return new int[0];
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseScheduleII c = new CourseScheduleII();
		int numCourses = 4; 
		int[][] prerequisites = {{1,0},{2,0},{3,1},{3,2}};
		int[] res = c.findOrder(numCourses, prerequisites);
		for (int i : res) {
			System.out.println(i);
		}
	}

}
