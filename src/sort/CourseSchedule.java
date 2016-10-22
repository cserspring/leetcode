package sort;

import java.util.LinkedList;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
    	// 1. Calculate the indgree of every node.
    	int[] indegree = new int[numCourses];
    	for (int i = 0 ; i < prerequisites.length; ++i) {
    		indegree[prerequisites[i][1]]++;
    	}

    	// 2. Initialize the queue, which contains the nodes whose indegree is 0.
        Queue<Integer> queue = new LinkedList<Integer>();        
    	for (int i = 0; i < indegree.length; ++i) {
    		if (indegree[i] == 0) {
    			queue.add(i);
    		}
    	}
    	
        return BFS(prerequisites, queue, indegree);
    }
    
    private boolean BFS(int[][] prerequisites, Queue<Integer> queue, int[] indegree) {
    	while (!queue.isEmpty()) {
    		int node = queue.poll();
    		// 3. Remove the node, recaculate the indegree of corresponding nodes.
    		adjustInDegree(prerequisites, indegree, queue, node);
    	}
    	
    	for (int i = 0; i < indegree.length; ++i) {
    		if (indegree[i] > 0)
    			return false;
    	}
    	
    	return true;
    }
        
    private void adjustInDegree(int[][] prerequisites, int[] indegree, Queue<Integer> queue, int visitedNode) {
    	for (int i = 0; i < prerequisites.length; ++i) {
    		if (prerequisites[i][0] == visitedNode && --indegree[prerequisites[i][1]] == 0) {
    			queue.add(prerequisites[i][1]);
    		}
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CourseSchedule c = new CourseSchedule();
		int numCourses = 2;
		int[][] prerequisites = {{0,1}};
		System.out.println(c.canFinish(numCourses, prerequisites));
	}

}
