package string;

public class LengthOfLastWord {

    public int lengthOfLastWord(String s) {
        int n = 0;
        if (s == null || (n = s.length()) == 0) return 0;
        int postSpaceIndex = -1;
        for (int i = n - 1; i >= 0; --i) {
        	if (s.charAt(i) != ' ') {
        		postSpaceIndex = i;
        		break;
        	}
        }
        
        int count = 0;
        for (int i = postSpaceIndex; i >= 0; --i) {
        	if (s.charAt(i) != ' ')
        		++count;
        	else
        		break;
        }
        
        return count;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "Hello world  ";
		LengthOfLastWord l = new LengthOfLastWord();
		System.out.println(l.lengthOfLastWord(s));
	}

}
