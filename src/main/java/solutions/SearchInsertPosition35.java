package solutions;

public class SearchInsertPosition35 {
    public int searchInsert(int[] nums, int target) {
        int low = 0;
        int max = nums.length - 1;

        while(low < max -1) {
            if(nums[low] == target) {
                return low;
            }

            if(nums[max] == target) {
                return max;
            }

            int mid = (max + low) / 2;

            if(nums[mid] >= target) {
                max = mid;
            } else {
                low = mid;
            }
        }

        if(nums[low] == target) {
            return low;
        }

        if(nums[max] == target) {
            return max;
        }

        if(nums[low] > target) {
            return low;
        } else if(nums[low]< target && nums[max] > target) {
            return max;
        } else {
            return max + 1;
        }
    }
}
