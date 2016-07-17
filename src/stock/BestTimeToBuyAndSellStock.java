package stock;

public class BestTimeToBuyAndSellStock {
	
    public int maxProfit(int[] prices) {
        int n;
        int max = 0;
        if (prices == null || (n = prices.length) == 0) return max;
        for (int i = 0; i < n - 1; ++i) {
        	for (int j = i + 1; j < n; ++j) {
        		int profit = prices[j] - prices[i];
        		if (profit > max)
        			max = profit;
        	}
        }
        
        return max;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStock b = new BestTimeToBuyAndSellStock();
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(b.maxProfit(prices));
	}

}
