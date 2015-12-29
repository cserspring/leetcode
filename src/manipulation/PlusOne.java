package manipulation;

public class PlusOne {

    public int[] plusOne(int[] digits) {
        int n = digits.length;
        int i = 0;
        for (; i < n; ++i)
        	if (digits[i] != 9)
        		break;
        if (i == n) {
        	int[] newDigits = new int[n + 1];
        	newDigits[0] = 1;
        	return newDigits;
        }
        
        --n;
        digits[n] += 1;
        while (n >= 0 && digits[n] >= 10) {
        	digits[n] = digits[n] % 10;
        	digits[n - 1] += 1;
        	--n;
        }
        
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
