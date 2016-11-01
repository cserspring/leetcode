package divideconquer;

import java.util.ArrayList;
import java.util.List;

public class DifferentWaysToAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        int n;
        if (input == null || (n = input.length()) == 0) return res;       
        for (int i = 0; i < n; ++i) {
        	char c = input.charAt(i);
        	if (c == '-' || c == '+' || c == '*') {
        		List<Integer> left = diffWaysToCompute(input.substring(0, i));
        		List<Integer> right = diffWaysToCompute(input.substring(i + 1, n));
        		for (int j = 0; j < left.size(); ++j) {
        			for (int k = 0; k < right.size(); ++k) {
        				switch (c) {
        					case '-':
        						res.add(left.get(j) - right.get(k));
        						break;
        					case '+':
        						res.add(left.get(j) + right.get(k));
        						break;
        					case '*':
        						res.add(left.get(j) * right.get(k));
        						break;
        				}
        			}
        		}
        	}
        }
        
        if (res.size() == 0)
        	res.add(Integer.valueOf(input.trim()));
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "2*3 - 4*5";
		DifferentWaysToAddParentheses d = new DifferentWaysToAddParentheses();
		for (int i : d.diffWaysToCompute(s))
			System.out.println(i);
	}

}
