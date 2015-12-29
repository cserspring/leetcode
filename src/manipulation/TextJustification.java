package manipulation;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int n = words.length;
        int i = 0;
        int len = 0;
        int start = 0;
        for (; i < n; ++i) {     
        	if (len + words[i].length() + (i == start ? 0 : 1) > maxWidth) {
        		justify(words, start, i - 1, res, maxWidth);
        		start = i;
        		len = 0;
        	}
        	len += words[i].length() + (i == start ? 0 : 1);
        }
        justify(words, start, n - 1, res, maxWidth);
        return res;
    }
    
    private void justify(String[] words, int start, int end, List<String> res, int L) {
    	int count = 0;
    	int total = 0;
    	for (int i = start; i <= end; ++i) {
    		++count;
    		total += words[i].length();
    	}
    	int rem = L - total;
    	// Only one word in this line
    	if (count == 1) {
    		String space = "";
    		for (int i = 0; i < rem; ++i) space += " ";
    		res.add(words[start] + space);
    	} else if (end == words.length - 1) { // This is the last line
    		String s = words[start];
    		for (int i = 1; i <= count - 1; ++i) {
    			s += " " + words[start + i];
    		}
    		for (int i = 0; i < rem - count + 1; ++i) s+= " ";
    		res.add(s);
    	} else { // General case
    		int avg = rem / (count - 1);
    		int leftMore = rem - avg * (count  - 1);
    		String s = words[start];
    		for (int i = 1; i <= count - 1; ++i) {
    			for (int j = 0; j < avg; ++j) s += " ";
    			s += leftMore-- > 0 ? " " : "";
    			s += words[start + i];
    		}
    		res.add(s);
    	}
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] words = { "This", "is", "an", "example", "of", "text", "justification." };
		TextJustification t = new TextJustification();
		for (String s : t.fullJustify(words, 16)){
			System.out.println(s);
		}
	}

}
