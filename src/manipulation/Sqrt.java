package manipulation;

public class Sqrt {

    public int mySqrt(int x) {
    	if (x <= 1) return x;
    	int start = 1;
        int end = x / 2;
        while (start <= end) {
        	int mid = (start + end) / 2;
        	if (x / mid == mid)
        		return mid;
        	if (x / mid > mid)
        		start = mid + 1;
        	else
        		end = mid - 1;
        }

        return end;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Sqrt s = new Sqrt();
		System.out.println(s.mySqrt(0));
		System.out.println(s.mySqrt(1));
		System.out.println(s.mySqrt(2));
		System.out.println(s.mySqrt(3));
		System.out.println(s.mySqrt(5));
		System.out.println(s.mySqrt(7));
		System.out.println(s.mySqrt(9));
		System.out.println(s.mySqrt(15));
		System.out.println(s.mySqrt(40));
	}

}
