package stock;

public class BestTimeToBuyAndSellStockII {
    public int maxProfit(int[] prices) {
    	int n;
        int maxProfit = 0;
        if (prices == null || (n = prices.length) == 0) return maxProfit;
        for (int i = 1; i < n; ++i) {
        	int profit = prices[i] - prices[i-1];
        	if (profit > 0){
        		maxProfit += profit;
        	}
        }
        
        return maxProfit;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BestTimeToBuyAndSellStockII b = new BestTimeToBuyAndSellStockII();
		int[] prices = {7, 1, 5, 3, 6, 4};
		System.out.println(b.maxProfit(prices));
	}

}
