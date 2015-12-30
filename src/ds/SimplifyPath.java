package ds;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
    	String[] names = path.split("/");
    	Stack<String> s = new Stack<String>();
    	for (int i = 0; i < names.length; ++i) {
    		String name = names[i];
    		switch (name) {
    			case "":
    			case ".":
    				break;
    			case "..":
    				if (!s.isEmpty()) s.pop();
    				break;
    			default:
    				s.push(name);
    				break;
    		}
    	}
    	
    	if (s.isEmpty()) return "/";
    	StringBuilder res = new StringBuilder();
    	while (!s.isEmpty()) {
    		res.insert(0, "/" + s.pop());
    	}
    	
    	return res.toString();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String path = "/a/b/c////d/e/";
		SimplifyPath s = new SimplifyPath();
		System.out.println(s.simplifyPath(path));
	}

}
