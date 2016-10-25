package math;

public class RectangleArea {

    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
    	int area = (C - A) * (D - B) + (G - E) * (H - F);
    	if (C <= E || G <= A || F >= D || B >= H) return area;
    	int top = Math.min(D, H);
    	int bottom = Math.max(B, F);
    	int left = Math.max(A, E);
    	int right = Math.min(C, G);
    	return area - (right - left) * (top - bottom);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RectangleArea r = new RectangleArea();
		System.out.println(r.computeArea(-1500000001, 0, -1500000000, 1, 1500000000, 0, 1500000001, 1));
	}

}
