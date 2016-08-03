package math;

import java.util.HashMap;
import java.util.Map;

class Point {
    int x;
    int y;
    Point() { x = 0; y = 0; }
    Point(int a, int b) { x = a; y = b; }
}

public class MaxPointsOnALine {
	public int maxPoints(Point[] points) {
        int n;
        if (points == null || (n = points.length) == 0) return 0;
        if (n == 1) return 1;
        Map<Double, Integer> angles = new HashMap<Double, Integer>();
        int max = 0;
        for (int i = 0; i < n; ++i) {
        	int duplicate = 0;
        	angles.clear();
        	for (int j = i + 1; j < n; ++j) {
        		double angle = Double.MAX_VALUE;
        		if (points[j].x != points[i].x) {
        			angle = (double)(points[j].y - points[i].y) / (points[j].x - points[i].x);
        			if (angle == -0.0)
        				angle = Math.abs(angle);
        		} else if (points[j].y == points[i].y){
        			duplicate++; // The same point.
        			continue;
        		}
        		
        		if (angles.containsKey(angle)) {
        			angles.put(angle, angles.get(angle) + 1);
        		} else {
        			angles.put(angle, 1);
        		}
        	}
        	
        	int tmp = 0;
            for (Integer val : angles.values()) {
            	if (val > tmp)
            		tmp = val;
            }
            
            max = Math.max(max, tmp+duplicate);
        }
        
        return max + 1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
