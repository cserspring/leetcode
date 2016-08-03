package ds;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public int evalRPN(String[] tokens) {
    	int n;
    	if (tokens == null || (n = tokens.length) == 0) return 0;
        Stack<Integer> stack = new Stack<Integer>();
        for (int i = 0; i < n; ++i) {
        	switch (tokens[i]) {
        	case "+":
        		stack.push(stack.pop() + stack.pop());
        		break;
        	case "-":
        		int a = stack.pop();
        		int b = stack.pop();
        		stack.push(b - a);
        		break;
        	case "*":
        		stack.push(stack.pop()*stack.pop());
        		break;
        	case "/":
        		a = stack.pop();
        		b = stack.pop();
        		stack.push(b/a);
        		break;
       		default:
        			stack.push(Integer.parseInt(tokens[i]));
        	}
        }
        
        return stack.pop();
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
