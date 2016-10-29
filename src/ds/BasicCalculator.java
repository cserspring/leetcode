package ds;

import java.util.Stack;

public class BasicCalculator {
	// http://www.geeksforgeeks.org/expression-evaluation/
    public int calculate(String s) {
        int n;
        if (s == null || (n = s.length()) == 0) return 0;
        Stack<Integer> values = new Stack<Integer>(); 
        Stack<Character> ops = new Stack<Character>(); 
        for (int i = 0; i < n; ++i) {
        	char c = s.charAt(i);
        	if (Character.isWhitespace(c)) continue;
        	if (Character.isDigit(c)) {
        		String v = String.valueOf(c);
        		while (i + 1 < n && Character.isDigit(s.charAt(i + 1))) {
        			v += s.charAt(++i);
        		}
        		values.push(Integer.valueOf(v));
        	} else if (c == '(') {
        		ops.push(c);
        	} else if (c ==')') {
        		while (ops.peek() != '(') {
        			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        		}
        		ops.pop();
        	} else {
        		while (!ops.isEmpty() && hasPriority(c, ops.peek())) {
        			values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        		}
        		ops.push(c);
        	}
        }
        
        while (!ops.isEmpty()) {
        	values.push(applyOp(ops.pop(), values.pop(), values.pop()));
        }
        
        return values.pop();
    }
    
    private int applyOp(char op, int v1, int v2) {
    	switch (op) {
    		case '+':
    			return v2 + v1;
    		case '-':
    			return v2 - v1;
    		case '*':
    			return v2 * v1;
    		case '/':
    			return v2 / v1;
    		default:
    			return 0;
    	}
    }
    
    private boolean hasPriority(char op1, char op2) {
    	if (op2 == '(' || op2 == ')')
    		return false;
    	if ((op1 == '*' || op1 =='/') && (op2 == '+' || op2 == '-'))
    		return false;
    	return true;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BasicCalculator b = new BasicCalculator();
		System.out.println(b.calculate("0"));
		System.out.println(b.calculate("3+2*2"));
		System.out.println(b.calculate("(3 + 4 - 1)"));
		System.out.println(b.calculate("(30 + 4 - 1) / (2 + 1)"));
	}

}
