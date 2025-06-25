package solutions;

public class RemoveDuplicates26 {
    public int removeDuplicates(int[] nums) {
        int low = 1;
        int res = 1;

        if(nums.length == 1) {
            return res;
        }

        int prev = nums[0];

        while(low <= nums.length - 1) {
            if(nums[low] == prev) {
                nums[low] = Integer.MIN_VALUE;
            } else {
                res++;
                prev = nums[low];
            }
            low++;
        }

        if(res == nums.length) {
            return res;
        }

        low = 1;
        int max = 1;

        while(max <= nums.length - 1) {
            if(nums[max] == Integer.MIN_VALUE) {
                max++;
            } else {
                nums[low] = nums[max];
                low++;
                max++;
            }
        }

        return res;
    }
}
