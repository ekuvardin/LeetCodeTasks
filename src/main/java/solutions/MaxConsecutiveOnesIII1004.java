package solutions;

/*
yandex
 */
public class MaxConsecutiveOnesIII1004 {
    public int longestOnes(int[] nums, int k) {
        int start = 0;
        int end = 0;
        int countZero = 0;
        int max = 0;

        while(end<nums.length) {
            if(nums[end] == 0) {
                countZero++;
            }
            end++;

            if(countZero > k) {
                if(nums[start] == 0) {
                    countZero--;
                }
                max = Math.max(max, end - start - 1);
                start++;
            }
        }

        return Math.max(max, end - start);

    }
}
