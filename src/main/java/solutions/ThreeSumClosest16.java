package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
yandex

        ThreeSumClosest16 l = new ThreeSumClosest16();
        l.threeSumClosest(new int[]{1, 3, 4, 7, 8, 9}, 15);
        l.threeSumClosest(new int[]{0, 0, 0}, 1);
        l.threeSumClosest(new int[]{-1, 2, 1, -4}, 1);
        l.threeSumClosest(new int[]{4, 0, 5, -5, 3, 3, 0, -4, -5}, -2);
 */
public class ThreeSumClosest16 {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);

        return threeSum(nums, target);
    }

    int threeSum(int[] nums, int target) {
        int closestSum = nums[0] + nums[1] + nums[2];
        int minDiff = Math.abs(target - closestSum);

        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int sum = twoSum(nums, first, i + 1, closestSum, minDiff, target - first);

            int diff = Math.abs(sum - target);

            if (diff == 0) {
                return target;
            }

            if (diff < minDiff) {
                minDiff = diff;
                closestSum = sum;
            }
        }

        return closestSum;
    }

    int twoSum(int[] nums, int first, int index, int closestSum, int minDiff, int target) {
        int low = index;
        int max = nums.length - 1;

        int minimumDiff = minDiff;
        int closestSum1 = closestSum;

        while (low < max) {
            int sum = first + nums[low] + nums[max];
            int diff = Math.abs(target - nums[low] - nums[max]);
            if (target - nums[low] == nums[max]) {
                return first + nums[low] + nums[max];
            } else if (target - nums[low] > nums[max]) {
                low++;
            } else {
                max--;
            }

            if (diff < minimumDiff) {
                minimumDiff = diff;
                closestSum1 = sum;
            }
        }
        return closestSum1;
    }
}
