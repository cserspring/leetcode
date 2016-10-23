package sort;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	// 0. Create adjacent lists, which are used when recalculate the indegree.
    	List<List<Integer>> adjLists = new ArrayList<List<Integer>>(numCourses);
    	for (int i = 0; i < numCourses; ++i)
    		adjLists.add(new ArrayList<Integer>());
    	for (int i = 0; i < prerequisites.length; ++i) {
    		adjLists.get(prerequisites[i][1]).add(prerequisites[i][0]);
    	}
    	
    	// 1. Calculate the indgree of every node.
    	int[] indegree = new int[numCourses];
    	for (int i = 0 ; i < prerequisites.length; ++i) {
    		indegree[prerequisites[i][0]]++;
    	}

    	// 2. Initialize the queue, which contains the nodes whose indegree is 0.
        Queue<Integer> queue = new LinkedList<Integer>();        
    	for (int i = 0; i < indegree.length; ++i) {
    		if (indegree[i] == 0) {
    			queue.add(i);
    		}
    	}
    	
    	while (!queue.isEmpty()) {
    		// 3. Remove the node, recaculate the indegree of corresponding nodes.
    		int node = queue.poll();
    		for (int i = 0; i < adjLists.get(node).size(); ++i) {
    			if (--indegree[adjLists.get(node).get(i)] == 0) {
    				queue.add(adjLists.get(node).get(i));
    			}
    		}
    	}
    	
    	for (int i = 0; i < numCourses; ++i) {
    		if (indegree[i] > 0)
    			return false;
    	}
    	
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule c = new CourseSchedule();
		int numCourses = 2;
		int[][] prerequisites = {{0,1}, {1,0}};
		System.out.println(c.canFinish(numCourses, prerequisites));
	}

}
