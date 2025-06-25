package solutions;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.TreeMap;

public class SlidingWindowMaximum239 {

    public int[] maxSlidingWindow(int[] nums, int k) {
        // assume nums is not null
        int n = nums.length;
        if (n == 0 || k == 0) {
            return new int[0];
        }
        int[] result = new int[n - k + 1]; // number of windows
        Deque<Integer> win = new ArrayDeque<>(); // stores indices

        for (int i = 0; i < n; ++i) {
            // remove indices that are out of bound
            while (!win.isEmpty() && win.peekFirst() <= i - k) {
                win.pollFirst();
            }
            // remove indices whose corresponding values are less than nums[i]
            while (!win.isEmpty() && nums[win.peekLast()] < nums[i]) {
                win.pollLast();
            }
            // add nums[i]
            win.offerLast(i);
            // add to result
            if (i >= k - 1) {
                result[i - k + 1] = nums[win.peekFirst()];
            }
        }
        return result;
    }

    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            queue.add(nums[i]);
        }

        res[0] = queue.peek();

        for (int i = k; i < nums.length; i++) {
            queue.remove(nums[i - k]);
            queue.add(nums[i]);
            res[i - k + 1] = queue.peek();
        }

        return res;
    }

    public int[] maxSlidingWindow3(int[] nums, int k) {
        int[] res = new int[nums.length - k + 1];
        TreeMap<Integer, Integer> map = new TreeMap<>(Comparator.reverseOrder());

        for (int i = 0; i < k; i++) {
            Integer count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);
        }

        res[0] = map.firstKey();

        for (int i = k; i < nums.length; i++) {
            int key = nums[i - k];
            Integer count = map.get(key);
            if(count == 1) {
                map.remove(key);
            } else {
                map.put(key, count - 1);
            }

            count = map.getOrDefault(nums[i], 0);
            map.put(nums[i], count + 1);

            res[i - k + 1] = map.firstKey();
        }

        return res;
    }

}
