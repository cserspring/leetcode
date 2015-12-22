package string;

public class CountAndSay {

    public String countAndSay(int n) {
    	String s = "1";
    	while (--n > 0) {
    		StringBuilder sb = new StringBuilder();
    		int len = s.length();
    		int count = 1;
    		for (int i = 1; i <= len; ++i) {
    			if (i < len && s.charAt(i) == s.charAt(i - 1)) {
    				++count;    				
    			} else {
    				sb.append((char)(count + '0'));
    				sb.append(s.charAt(i - 1));
    				count = 1;
    			}
    		}
    		
    		s = sb.toString();
    	}
    	
    	return s;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CountAndSay c = new CountAndSay();
		System.out.println(c.countAndSay(6));
	}

}
