package manipulation;

import java.util.ArrayList;
import java.util.List;

public class TextJustification {

    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> res = new ArrayList<String>();
        int n = words.length;
        for (int i = 0; i < n;) {
        	int len = words[i].length(); 
        	if (i == n - 1) {
        		justify(words, i, n - 1, res, maxWidth);
        		break;
        	}
        	for (int j = i + 1; j < n; ++j) {
        		len += words[j].length() + 1;
        		if (len > maxWidth) {
        			justify(words, i, j - 1, res, maxWidth);
        			i = j;
        			break;
        		} else if (j == n - 1) {
        			justify(words, i, n - 1, res, maxWidth);
        			i = n;
        		}
        	}
        }
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
    	if (count == 1) {
    		String space = new String(new char[rem]).replace("\0", " ");
    		res.add(words[start] + space);
    	} else if (end == words.length - 1) {
    		String s = words[start];
    		for (int i = 1; i <= count - 1; ++i) {
    			s += " " + words[start + i];
    		}
    		s += new String(new char[rem - count + 1]).replace("\0", " ");
    		res.add(s);
    	} else {
    		int avg = rem / (count - 1);
    		int leftMore = rem - avg * (count  - 1);
    		String s = words[start];
    		for (int i = 1; i <= count - 1; ++i) {
    			s += new String(new char[avg]).replace("\0", " ");
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
