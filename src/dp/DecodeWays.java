package dp;

public class DecodeWays {

	public int numDecodings(String s) {
		int n;
		if (s == null || (n = s.length()) == 0) return 0;
		int[] dp = new int[n + 1];
		dp[0] = 1;
		if (s.charAt(0) == '0') return 0;
		dp[1] = 1;

		for (int i = 2; i <= n; ++i) {
			int c1 = 0;
			if (s.charAt(i - 1) != '0')
				c1 = dp[i - 1];
			int c2 = 0;
			if (s.charAt(i - 2) == '1' || (s.charAt(i - 2) == '2' && s.charAt(i - 1) < '7'))
				c2 = dp[i - 2];
			dp[i] = c1 + c2;
		}
		
		return dp[n];
	}
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DecodeWays d = new DecodeWays();
		System.out.println(d.numDecodings("10") == 1);
		System.out.println(d.numDecodings("101") == 1);
		System.out.println(d.numDecodings("1001") == 0);
		System.out.println(d.numDecodings("10012") == 0);
		System.out.println(d.numDecodings("0012") == 0);
		System.out.println(d.numDecodings("12") == 2);
		System.out.println(d.numDecodings("128") == 2);
		System.out.println(d.numDecodings("27") == 1);
		System.out.println(d.numDecodings("99") == 1);
	}

}
