package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/*
yandex
 */
public class ThreeSum15 {
    public List<List<Integer>> threeSum(int[] nums) {
        if (nums.length < 3) {
            return new ArrayList<>();
        }

        Arrays.sort(nums);

        return thSum(nums);
    }

    List<List<Integer>> thSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while (i < nums.length - 2) {
            List<List<Integer>> prev = twoSum(nums, i + 1, -nums[i]);

            for (List<Integer> temp : prev) {
                temp.add(0, nums[i]);
            }

            result.addAll(prev);

            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
            i++;
        }

        return result;
    }

    List<List<Integer>> twoSum(int[] nums, int index, int target) {
        ArrayList<List<Integer>> res = new ArrayList<>();
        int low = index;
        int max = nums.length - 1;
        while (low < max) {
            if (target - nums[low] == nums[max]) {
                List<Integer> temp = new ArrayList<>();
                temp.add(nums[low]);
                temp.add(target - nums[low]);
                res.add(temp);

                while (low < max && nums[low] == nums[low + 1]) low++;
                while (low < max && nums[max - 1] == nums[max]) max--;
                low++;
                max--;
            } else if (target - nums[low] > nums[max]) {
                low++;
            } else {
                max--;
            }
        }
        return res;
    }
}
