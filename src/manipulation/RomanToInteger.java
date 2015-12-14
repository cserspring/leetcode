package manipulation;

import java.util.HashMap;

public class RomanToInteger {

    public int romanToInt(String s) {
    	int len = 0;
    	if (s == null || (len = s.length()) == 0) return 0;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int res = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; --i) {
        	if (map.get(s.charAt(i + 1)) > map.get(s.charAt(i)))
        		res -= map.get(s.charAt(i));
        	else
        		res += map.get(s.charAt(i));
        }
        
        return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		RomanToInteger r = new RomanToInteger();
		System.out.println(r.romanToInt("MCM"));
	}

}
