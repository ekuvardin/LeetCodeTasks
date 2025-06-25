package solutions;

/*
yandex
1,1,1,1,1,1,1,1,1,13,1,1,1,1,1,1,1,1,1,1,1,1
 */
public class SearchinRotatedSortedArrayII81 {
    public boolean search(int[] nums, int target) {
        int low = 0;
        int max = nums.length - 1;

        while(low <= max - 2) {
            if(nums[low] == target) {
                return true;
            }

            if(nums[max] == target) {
                return true;
            }
            int old = nums[low];
            while(nums[low] == old && low <= max - 1) {
                low++;
            }

            old = nums[max];
            while(nums[max] == old && low <= max - 1) {
                max--;
            }

           if(low > max - 2) {
               break;
           }

            int mid = (low + max) / 2;
            boolean isPivotLeft = nums[low] > nums[mid];
            boolean isPivotRight = nums[mid] > nums[max];

            if(!isPivotLeft && !isPivotRight) {
                if(target < nums[mid]) {
                    max = mid;
                } else {
                    low = mid;
                }
            } else if(isPivotLeft && !isPivotRight) {
                if(target >= nums[mid] && target <= nums[max]) {
                    low = mid;
                } else {
                    max = mid;
                }
            } else { // !isPivotLeft && isPivotRight
                if(target >= nums[low] && target <= nums[mid]) {
                    max = mid;
                } else {
                    low = mid;
                }
            }

        }

        if(nums[low] == target) {
            return true;
        }

        if(nums[max] == target) {
            return true;
        }

        return false;
    }
}
