package manipulation;

public class IntegerToRoman {

    public String intToRoman(int num) {
		int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4 ,1};
		String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
		String res = "";
		for (int i = 0; num > 0 && i < 13; ++i) {
			int times = num / nums[i];
			num = num % nums[i];
			for (; times > 0; --times)
				res += symbols[i];
		}
		
		return res;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IntegerToRoman i = new IntegerToRoman();
		System.out.println(i.intToRoman(19));
	}

}
