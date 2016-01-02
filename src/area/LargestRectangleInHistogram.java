package area;

public class LargestRectangleInHistogram {

    public int largestRectangleArea(int[] height) {
    	int n = height.length;
    	int max = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        for (int pos = 0; pos < n; ++pos) {
        	left[pos] = right[pos] = pos;
        	int i = pos - 1;
        	for (; i >= 0; --i) {
        		if (height[i] < height[pos]) {
        			left[pos] = i + 1;
        			break;
        		}
        	}
        	if (i == -1) left[pos] = 0;
        	
        	for (i = pos + 1; i < n; ++i) {
        		if (height[i] < height[pos]) {
        			right[pos] = i - 1;
        			break;
        		}
        	}
        	if (i == n) right[pos] = n - 1;
        	int area = height[pos] * (right[pos] - left[pos] + 1);
        	if (area > max)
        		max = area;
        }

        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 1,1,1,1 };
		LargestRectangleInHistogram l = new LargestRectangleInHistogram();
		System.out.println(l.largestRectangleArea(height));
	}

}
