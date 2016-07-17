package stock;

public class BestTimeToBuyAndSellStock {
	
    public int maxProfit(int[] prices) {
        int n;
        int max = 0;
        if (prices == null || (n = prices.length) == 0) return max;
        int min = prices[0];
        for (int i = 1; i < n; ++i) {
        	min = Math.min(min, prices[i]);
        	max = Math.max(max, prices[i] - min);
        	
        	/*
        	if (prices[i] < min) {
        		min = prices[i];
        	} else {
        		int profit = prices[i] - min;
        		if (profit > max)
        			max = profit;
        	}*/
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
