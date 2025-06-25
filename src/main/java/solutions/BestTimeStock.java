package solutions;

public class BestTimeStock {
    public int maxProfit(int[] prices) {
        int result = 0;
        int buyPrice = Integer.MAX_VALUE;

        for (int price : prices) {
            if (price >= buyPrice) {
                result += price - buyPrice;
            }
            buyPrice = price;
        }

        return result;
    }
}
