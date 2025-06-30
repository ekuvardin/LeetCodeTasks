package solutions;

import java.util.HashMap;
import java.util.Map;
/*
Given an integer array nums and an integer k, return the number of non-empty subarrays that have a sum divisible by k.

A subarray is a contiguous part of an array.



Example 1:

Input: nums = [4,5,0,-2,-3,1], k = 5
Output: 7
Explanation: There are 7 subarrays with a sum divisible by k = 5:
[4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]

Example 2:

Input: nums = [5], k = 9
Output: 0



Constraints:

    1 <= nums.length <= 3 * 104
    -104 <= nums[i] <= 104
    2 <= k <= 104


yandex
 */
public class SubarraySumsDivisiblebyK974 {
    public int subarraysDivByK(int[] nums, int k) {
        int count = 0;
        int sum = 0;

        Map<Integer, Integer> map = new HashMap<>(nums.length);

        for(int i=0; i<nums.length;i++) {
            sum = sum + nums[i];

            if(sum % k == 0) {
                count++;
            }

            int mod = sum % k;
            if(mod < 0) {
                mod = mod +k;
            }

            if(map.get(mod) == null) {
                map.put(mod, 1);
            } else {
                count = count + map.get(mod);
                map.put(mod, map.get(mod) + 1);
            }
        }

        return count;
    }
}
