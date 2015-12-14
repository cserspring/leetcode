package area;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int n = height.length;
        int maxArea = 0;
        int i = 0;
        int j = n - 1;
        while (i < j) {
        	int area = Math.min(height[i], height[j]) * (j - i);
        	if (height[i] <= height[j]) 
        		++i;
        	else 
        		--j;        	
        	
        	if (area > maxArea)
        		maxArea = area;
        }
        
        return maxArea;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
