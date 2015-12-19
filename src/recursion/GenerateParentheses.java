package recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        generate(res, n, n, "");
        return res;
    }
    
    private void generate(List<String> res, int left, int right, String s) {
    	if (left == 0 && right == 0) {
    		res.add(s);
    		return;
    	}
    	
    	if (left > 0) 
    		generate(res, left - 1, right, s + "(");
    	
    	if (right > 0 && right > left) 
    		generate(res, left, right - 1, s + ")");    	
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenerateParentheses g = new GenerateParentheses();
		for (String s : g.generateParenthesis(3)) {
			System.out.println(s);
		}
	}

}
