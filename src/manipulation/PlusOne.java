package manipulation;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = n - 1;
        for (; i >= 0; --i) {
        	if (digits[i] != 9) {
        		++digits[i];
        		return digits;
        	} else {
        		digits[i] = 0;
        	}
        }
        
        digits = new int[n + 1];
        digits[0] = 1;
        return digits;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] digits = { 8,9,9 };
		PlusOne p = new PlusOne();
		for (int i : p.plusOne(digits))
			System.out.println(i);
	}

}
