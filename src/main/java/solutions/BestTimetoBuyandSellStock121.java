package solutions;

public class BestTimetoBuyandSellStock121 {
    public int maxProfit(int[] prices) {
        int bestBuyPrice = prices[0];
        int diff = 0;

        for(int i= 1;i<prices.length;i++) {
            if(prices[i]<bestBuyPrice) {
                bestBuyPrice = prices[i];
            }

            diff = Math.max(diff,prices[i] - bestBuyPrice);
        }

        return diff;
    }
}
