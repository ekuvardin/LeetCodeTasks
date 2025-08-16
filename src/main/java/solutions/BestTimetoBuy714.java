package solutions;

/*
yandex
l.maxProfit(new int[]{1,3,2,8,4,9} ,2);

 */
public class BestTimetoBuy714 {
    public int maxProfit(int[] prices, int fee) {
        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, cash - prices[i]);
            cash = Math.max(cash, hold + prices[i] - fee);
        }

        return cash;
    }

    public static String largestGoodInteger(String num) {
        int max = -1;
        int start = 0;
        int count = 1;
        int end = 1;

        while (end < num.length() && max != 9) {
            if (num.charAt(end) == num.charAt(start)) {
                count++;

                if (count == 3) {
                    if ((num.charAt(end) - '0') > max) {
                        max = (num.charAt(end) - '0');
                    }

                    while (end < num.length() && num.charAt(end) == num.charAt(start)) {
                        end++;
                    }

                    start = end;
                    end = start + 1;
                    count = 1;
                } else {
                    end++;
                }
            } else {
                start = end;
                end = start + 1;
                count = 1;
            }
        }

        return max == -1 ? "" : String.valueOf(max).repeat(3);
    }
}
