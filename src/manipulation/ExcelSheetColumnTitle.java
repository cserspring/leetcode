package manipulation;

public class ExcelSheetColumnTitle {
	private int NUM = 26;
	// 把A看成0，把Z看成25
    public String convertToTitle(int n) {
        String res = "";
        while (n > 0) {
        	n--;
        	char c = (char)('A' + (n % NUM));
        	n = n / NUM;        	
        	res = c + res;
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
		for (int i = 1; i < 100; ++i)
			System.out.println(e.convertToTitle(i));
	}

}
