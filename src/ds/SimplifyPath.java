package ds;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
    	path += "/";
        int n = path.length();
        int start = -1;
        int end = -1;
        List<String> strs = new ArrayList<String>();
        for (int i = 0; i < n; ++i) {
        	if (i + 1 < n && path.charAt(i) == '/' && path.charAt(i + 1) != '/') 
        		start = i;
        	if (i + 1 < n && path.charAt(i) != '/' && path.charAt(i + 1) == '/')
        		end = i;
        	if (start != -1 && end != -1) {
        		strs.add(path.substring(start, end + 1));
        		start = -1;
        		end = -1;
        	}
        }
        
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < strs.size(); ++i) {
        	String str = strs.get(i);
        	switch (str) {
        		case "/..":
        			if (!stack.isEmpty())
        				stack.pop();
        			break;
        		case "/.":
        			break;
        		default:
        			stack.push(str);
        			break;
        	}
        }
        
        if (stack.isEmpty()) return "/";
        
        StringBuilder sb = new StringBuilder();
        
        while (!stack.isEmpty())
        	sb.insert(0, stack.pop());
        return sb.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/...";
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath(path));
	}

}
