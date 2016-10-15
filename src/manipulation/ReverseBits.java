package manipulation;

public class ReverseBits {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int size = 32;
        int res = 0;
        for (int i = 0; i < size; ++i) {
        	res = (res << 1) + (n & 1);
        	n = n >> 1;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseBits r = new ReverseBits();
		System.out.println(r.reverseBits(43261596));
	}

}
