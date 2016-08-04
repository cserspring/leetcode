package string;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
    	int n;
        if (s == null || (n = s.length()) == 0) return s;
        StringBuilder sb = new StringBuilder("");
        --n;
        
        while (n >= 0) {
        	int end = n;
        	while (end >= 0 && Character.isWhitespace(s.charAt(end)))
        		--end;
        	int start = end;
        	while (start >= 0 && !Character.isWhitespace(s.charAt(start)))
        		--start;
        	sb.append(s.substring(start+1, end+1) + " ");
        	n = start;
        }
        
        return sb.toString().trim();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = " ";
		ReverseWordsInAString r = new ReverseWordsInAString();
		System.out.println(r.reverseWords(s));
	}

}
