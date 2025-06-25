package solutions;

/*
yandex
 */
public class FindMinimuminRotatedSortedArray153 {
    public int findMin(int[] nums) {
        int low = 0;
        int max = nums.length - 1;

        while(low<= max - 2) {
            if(nums[low] < nums[max]) {
                return nums[low];
            }

            int mid = (low + max) / 2;
            boolean isPivotRight = nums[mid] > nums[max];

            if(!isPivotRight) {
                max = mid;
            } else {
                low = mid;
            }
        }

        return Math.min(nums[low], nums[max]);
    }
}
