package area;

import java.util.Stack;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] height) {
    	Stack<Integer> stack = new Stack<Integer>();
    	int max = 0;
    	int n = height.length;
    	int[] newHeight = new int[n + 1];
    	for (int i = 0; i < n; ++i) newHeight[i] = height[i];
    	newHeight[n] = 0;
    	int i = 0;
    	while (i < n + 1) {
    		if (stack.isEmpty() || newHeight[stack.peek()] <= newHeight[i]) {
    			stack.push(i++);
    		} else {
    			int index = stack.pop();
    			int area = (stack.isEmpty() ? i : (i - stack.peek() - 1)) * newHeight[index];
    			max = (max < area ? area : max);
    		}
    	}
    	
    	return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1,1 };
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
		System.out.println(l.largestRectangleArea(height));
	}

}
