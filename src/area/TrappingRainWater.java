package area;

public class TrappingRainWater {

    public int trap(int[] height) {
        int n = height.length;
        int area = 0;
        int[] left = new int[n];
        int[] right = new int[n];
        int leftMaxHeight = 0;
        int rightMaxHeight = 0;
        for (int i = 0; i < n; ++i) {
        	if (i > 0 && height[i - 1] > leftMaxHeight) {
        		leftMaxHeight = height[i - 1];
        	}
        	left[i] = leftMaxHeight;
        	
        	if (i < n - 1 && height[n - 1 - i] > rightMaxHeight) {
        		rightMaxHeight = height[n - 1 - i];
        	}
        	if (n - 2 >= i)
        		right[n - 2 - i] = rightMaxHeight;
        }
        
        for (int i = 1; i < n - 1; ++i) {
        	int min = Math.min(left[i], right[i]);
        	area += min > height[i] ? (min - height[i]) : 0;
        }
        
        return area;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] height = { 0,1,0,2,1,0,1,3,2,1,2,1 /*5,2,1,2,1,5*/ };
		TrappingRainWater t = new TrappingRainWater();
		System.out.println(t.trap(height));
	}

}
