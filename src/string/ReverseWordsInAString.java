package string;

public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) return s;
        String[] arr = s.trim().split("\\s+");
        int n = arr.length;
        for (int i = 0; i < n/2; ++i) {
        	String tmp = arr[i];
        	arr[i] = arr[n-1-i];
        	arr[n-1-i] = tmp;
        }
        
        return String.join(" ", arr);
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "the sky is blue";
		ReverseWordsInAString r = new ReverseWordsInAString();
		System.out.println(r.reverseWords(s));
	}

}
