package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class BestTimetoBuyandSellStockwithCooldown309 {

    public int maxProfit(int[] prices) {
        int[] hold = new int[prices.length];
        int[] sell = new int[prices.length];
        int[] cooldown = new int[prices.length];

        hold[0] = -prices[0];
        cooldown[0] = 0;
        sell[0] = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            cooldown[i] = Math.max(cooldown[i - 1], Math.max(hold[i - 1], sell[i - 1]));
            hold[i] = Math.max(hold[i - 1], cooldown[i - 1] - prices[i]);
            sell[i] = Math.max(sell[i - 1], hold[i - 1] + prices[i]);
        }

        return Math.max(sell[prices.length - 1], 0);
    }

    public int maxProfit2(int[] prices) {

        int hold = -prices[0];
        int cooldown = 0;
        int sell = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            int prevHold = hold;
            int prevCooldown = cooldown;
            int prevSell = sell;

            cooldown = Math.max(prevCooldown, Math.max(prevHold, prevSell));
            hold = Math.max(prevHold, prevCooldown - prices[i]);
            sell = Math.max(prevSell, prevHold + prices[i]);
        }

        return Math.max(sell, 0);
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        if (nums.length < k) {
            return 0;
        }

        int start = 0;
        int end = 0;
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        long currentSum = 0;
        long maxSum = 0;

        while (end < nums.length) {
            int len = end - start + 1;
            set.add(nums[end]);
            int tmp = map.getOrDefault(nums[end], 0);
            map.put(nums[end], tmp + 1);
            currentSum += nums[end];

            if (start + k - 1 == end) {
                if (len == set.size()) {
                    maxSum = Math.max(maxSum, currentSum);
                }

                updatedMap(map, set, nums, start);
                currentSum-=nums[start];
                start++;
            }

            end++;
        }

        return maxSum;
    }

    public static void updatedMap(Map<Integer, Integer> map, Set<Integer> set, int[] nums, int start) {
        int tmp = map.get(nums[start]);

        if (tmp == 1) {
            set.remove(nums[start]);
            map.remove(nums[start]);
        } else {
            map.put(nums[start], tmp - 1);
        }
    }
}
