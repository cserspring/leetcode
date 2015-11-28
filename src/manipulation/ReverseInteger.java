package manipulation;

public class ReverseInteger {

    public int reverse(int x) {
        int y = Math.abs(x);
        int result = 0;
        while (y > 0) {
        	int newResult = result * 10;
        	if (result != 0 && newResult / 10 != result) return 0;
        	
        	result = newResult + y % 10;
        	if (result < newResult) return 0;
        	
        	y = y / 10;
        }
        
        return x > 0 ? result : -result;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(1534236469));
	}

}
