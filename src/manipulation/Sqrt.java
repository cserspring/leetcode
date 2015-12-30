package manipulation;

public class Sqrt {

    public int mySqrt(int x) {
        int median = x / 2;
        int root = x;
        for (int i = median; i >= 1; --i) {
        	if (x / i >= i) {
        		root = i;
        		break;
        	}
        }
        return root;
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
