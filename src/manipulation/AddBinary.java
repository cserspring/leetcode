package manipulation;

public class AddBinary {

    public String addBinary(String a, String b) {
        int alen = a.length();
        int blen = b.length();
        StringBuilder sb = new StringBuilder();
        add(alen - 1, blen - 1, 0, a, b, sb);
        return sb.toString();
    }
    
    private void add(int i, int j, int carry, String a, String b, StringBuilder sb) {
    	if (i <0 && j < 0 && carry < 1) return;
    	int m = i >= 0 ? (a.charAt(i) - '0') : 0;
    	int n = j >= 0 ? (b.charAt(j) - '0') : 0;
    	int total = m + n + carry;
    	add(i - 1, j - 1, total / 2, a, b, sb);
    	sb.append((char)(total % 2 +'0'));
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		AddBinary a = new AddBinary();
		System.out.println(a.addBinary("0", "0"));
	}

}
