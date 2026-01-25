package solutions;

import java.util.HashMap;
import java.util.Map;

/*
Description
Editorial
Editorial
Solutions
Solutions
Accepted
Accepted
Submissions
Submissions
Code
Testcase
Testcase
Test Result
3583. Count Special Triplets
Solved
Medium
Topics
premium lock iconCompanies
Hint

You are given an integer array nums.

A special triplet is defined as a triplet of indices (i, j, k) such that:

    0 <= i < j < k < n, where n = nums.length
    nums[i] == nums[j] * 2
    nums[k] == nums[j] * 2

Return the total number of special triplets in the array.

Since the answer may be large, return it modulo 109 + 7.



Example 1:

Input: nums = [6,3,6]

Output: 1

Explanation:

The only special triplet is (i, j, k) = (0, 1, 2), where:

    nums[0] = 6, nums[1] = 3, nums[2] = 6
    nums[0] = nums[1] * 2 = 3 * 2 = 6
    nums[2] = nums[1] * 2 = 3 * 2 = 6

Example 2:

Input: nums = [0,1,0,0]

Output: 1

Explanation:

The only special triplet is (i, j, k) = (0, 2, 3), where:

    nums[0] = 0, nums[2] = 0, nums[3] = 0
    nums[0] = nums[2] * 2 = 0 * 2 = 0
    nums[3] = nums[2] * 2 = 0 * 2 = 0

Example 3:

Input: nums = [8,4,2,8,4]

Output: 2

Explanation:

There are exactly two special triplets:

    (i, j, k) = (0, 1, 3)
        nums[0] = 8, nums[1] = 4, nums[3] = 8
        nums[0] = nums[1] * 2 = 4 * 2 = 8
        nums[3] = nums[1] * 2 = 4 * 2 = 8
    (i, j, k) = (1, 2, 4)
        nums[1] = 4, nums[2] = 2, nums[4] = 4
        nums[1] = nums[2] * 2 = 2 * 2 = 4
        nums[4] = nums[2] * 2 = 2 * 2 = 4



Constraints:

    3 <= n == nums.length <= 105
    0 <= nums[i] <= 105


 */
public class CountSpecialTriplets3583 {

    public int specialTriplets(int[] nums) {
        int mod = 1000000007;
        Map<Integer, Integer> mapLeft = new HashMap<>();
        Map<Integer, Integer> mapRight = new HashMap<>();

        for (int i = 1; i < nums.length; i++) {
            mapRight.put(nums[i], mapRight.getOrDefault(nums[i], 0) + 1);
        }

        mapLeft.put(nums[0], 1);

        long res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            int rightValue = mapRight.get(nums[i]);
            if (rightValue > 1) {
                mapRight.put(nums[i], rightValue - 1);
            } else {
                mapRight.remove(nums[i]);
            }

            int val = nums[i] * 2;
            long leftCount = mapLeft.getOrDefault(val, 0);
            long rightCount = mapRight.getOrDefault(val, 0);

            res = (res + (leftCount * rightCount) % mod) % mod;

            mapLeft.put(nums[i], mapLeft.getOrDefault(nums[i], 0) + 1);
        }

        return (int) res;
    }
}
