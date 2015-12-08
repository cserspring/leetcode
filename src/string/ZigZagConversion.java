package string;

public class ZigZagConversion {

    public String convert(String s, int numRows) {
    	if (s == null || numRows == 1) return s;
        int gap = 2 * (numRows - 1);
        int len = s.length();
        StringBuilder sb = new StringBuilder("");
        
        for (int i = 0; i < numRows; ++i) {
        	for (int j = i; j < len; j += gap) {
        		sb.append(s.charAt(j));
        		int next = j + 2 * (numRows - i - 1);
        		if (i != 0 && i != numRows - 1 && next < len)
        			sb.append(s.charAt(next));
        	}
        }
        
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "A";
		ZigZagConversion z = new ZigZagConversion();
		System.out.println(z.convert(s, 1));
	}

}
