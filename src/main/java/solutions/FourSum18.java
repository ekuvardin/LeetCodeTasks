package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given an array nums of n integers, return an array of all the unique quadruplets [nums[a], nums[b], nums[c], nums[d]] such that:

    0 <= a, b, c, d < n
    a, b, c, and d are distinct.
    nums[a] + nums[b] + nums[c] + nums[d] == target

You may return the answer in any order.



Example 1:

Input: nums = [1,0,-1,0,-2,2], target = 0
Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

Example 2:

Input: nums = [2,2,2,2,2], target = 8
Output: [[2,2,2,2]]



Constraints:

    1 <= nums.length <= 200
    -109 <= nums[i] <= 109
    -109 <= target <= 109


yandex
 */
public class FourSum18 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        if(nums.length < 4) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);
        return ksum(nums, target, 4, 0);
    }

    public  List<List<Integer>> ksum(int[] nums, long target, int k, int index) {
        if(k==2) {
            return twoSum(nums, target, index);
        }

        ArrayList<List<Integer>> res = new ArrayList<>();

        int i = index;
        while(i<nums.length - k + 1) {
            List<List<Integer>> temp = ksum(nums, target - nums[i], k-1, i+1);

            for(List<Integer> tt: temp) {
                tt.add(0, nums[i]);
            }

            res.addAll(temp);

            while(i<nums.length - k+ 1 && nums[i] == nums[i+1]) {
                i++;
            }

            i++;
        }

        return res;
    }

    public  List<List<Integer>> twoSum(int[] nums, long target, int index) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int low = index;
        int max = nums.length - 1;

        while(low < max) {
            int sum = nums[low] + nums[max];
            if(sum == target) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[low]);
                temp.add(nums[max]);
                res.add(temp);

                while(low<max && nums[low] == nums[low+1]) {
                    low++;
                }

                while(low<max && nums[max] == nums[max-1]) {
                    max--;
                }

                low++;
                max--;
            } else if(sum > target) {
                max--;
            } else {
                low++;
            }
        }

        return res;
    }
}
