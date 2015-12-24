package area;

public class TrappingRainWater {

    public int trap(int[] height) {
        int n;
        if (height == null || (n = height.length) == 0) return 0;
        int area = 0;
        int maxHeight = height[0];
        int maxHeightIndex = 0;
        for (int i = 1; i < n; ++i) {
        	if (height[i] > maxHeight) {
        		maxHeight = height[i];
        		maxHeightIndex = i;
        	}
        }
        
        int leftMax = height[0];
        for (int i = 1; i < maxHeightIndex; ++i) {
        	if (height[i] > leftMax)
        		leftMax = height[i];
        	area += (leftMax - height[i]);
        }
        
        int rightMax = height[n - 1];
        for (int i = n - 2; i > maxHeightIndex; --i) {
        	if (height[i] > rightMax) 
        		rightMax = height[i];
        	area += rightMax - height[i];
        }
        
        return area;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { /*0,1,0,2,1,0,1,3,2,1,2,1*/ 5,2,1,2,1,5 };
		TrappingRainWater t = new TrappingRainWater();
		System.out.println(t.trap(height));
	}

}
