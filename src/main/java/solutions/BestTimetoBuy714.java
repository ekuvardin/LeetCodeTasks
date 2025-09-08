package solutions;

/*
yandex
l.maxProfit(new int[]{1,3,2,8,4,9} ,2);
      BestTimetoBuy714.maxProfit(new int[]{1,3,7,5,10,3},3);

 */
public class BestTimetoBuy714 {
    public static int maxProfit(int[] prices, int fee) {
        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, hold + prices[i] - fee);
        }

        return cash;
    }
}
