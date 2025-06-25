package solutions;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int runningSum = nums[0];
        int lastIndex = 0;

        for(int i=1;i<nums.length;i++) {
            if(runningSum + nums[i] <= nums[i]) {
                runningSum = nums[i];
                lastIndex = i;
            } else {
                runningSum = runningSum + nums[i];
            }
            sum = Math.max(runningSum, sum);

        }


        return sum;
    }
}
