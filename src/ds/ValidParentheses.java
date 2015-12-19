package ds;

import java.util.Stack;

public class ValidParentheses {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        int len = s.length();
        for (int i = 0; i < len; ++i) {
        	char c = s.charAt(i);
        	switch (c) {
        	case '(':
        		
        	case '[':
        		
        	case '{':
        		stack.push(c);
        		break;
        	case ')':
        		if (stack.isEmpty() || stack.pop() != '(')
        			return false;
        		break;
        	case ']':
        		if (stack.isEmpty() || stack.pop() != '[')
        			return false;
        		break;
        	case '}':        		
        		if (stack.isEmpty() || stack.pop() != '{')
        			return false;
        		break;
        	}
        }
        
        return stack.isEmpty();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ValidParentheses v = new ValidParentheses();
		// Test case 1
		System.out.println(v.isValid("()[]}"));
		// Test case 2
		System.out.println(v.isValid("("));
	}

}
