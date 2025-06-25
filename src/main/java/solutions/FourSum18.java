package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
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
