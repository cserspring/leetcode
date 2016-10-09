package manipulation;

public class ExcelSheetColumnNumber {
	private int FACTOR = 26;
	
    public int titleToNumber(String s) {
        int n;
        if (s == null || (n = s.length()) == 0) return 0;
        int ans = 0;
        for (int i = n - 1; i >= 0; --i) {
        	int cur = s.charAt(i) - 'A' + 1;
        	ans += cur * power (n - 1 - i);
        }
        
        return ans;
    }
    
    private int power(int n) {
    	int ans = 1;
    	for (int i = 0; i < n; ++i) {
    		ans *= FACTOR;
    	}
    	
    	return ans;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnNumber e = new ExcelSheetColumnNumber();
		System.out.println(e.titleToNumber("A"));
		System.out.println(e.titleToNumber("B"));
		System.out.println(e.titleToNumber("Z"));
		System.out.println(e.titleToNumber("AA"));
		System.out.println(e.titleToNumber("AB"));
		System.out.println(e.titleToNumber("ABC"));
		System.out.println(e.titleToNumber("ABCD"));
	}

}
