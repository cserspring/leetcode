package manipulation;

public class MultiplyStrings {

    public String multiply(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int len = len1 + len2;
        int[] res = new int[len];
        for (int i = len1 - 1; i >= 0; --i) {
        	for (int j = len2 - 1; j >= 0; --j) {
        		multiply(num1, i, num2, j, res, len);
        	}
        }
        StringBuilder sb = new StringBuilder();
        int i = len - 1;
        while (i >= 0 && res[i] == 0) --i;
        
        if (i == -1) sb.append('0');
        for (; i >= 0; --i) {
        	sb.append((char)(res[i] + '0'));
        }
        
        return sb.toString();
    }
    
    private void multiply(String num1, int i, String num2, int j, int[] res, int len) {
    	int m = num1.charAt(i) - '0';
    	int n = num2.charAt(j) - '0';
    	int value = m * n;
    	int index = len - i - j - 2;
    	res[index] = res[index] + value;
    	res[index + 1] = res[index + 1] + res[index] / 10;
    	res[index] = res[index] % 10;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MultiplyStrings m = new MultiplyStrings();
		System.out.println(m.multiply("11", "11"));
	}

}
