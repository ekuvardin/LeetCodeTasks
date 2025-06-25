package solutions;

/*
yandex
 */
public class SearchinRotatedSortedArray33 {

    public int search(int[] nums, int target) {
        int low = 0;
        int max = nums.length - 1;

        while (low <= max - 2) {
            if (nums[low] == target) {
                return low;
            }

            if (nums[max] == target) {
                return max;
            }

            int mid = (low + max) / 2;
            boolean isPivotRight = isPivot(mid, max, nums);
            boolean isPivotLeft = isPivot(low, mid, nums);

            if (!isPivotRight && !isPivotLeft) {
                if (target < nums[mid]) {
                    max = mid;
                } else {
                    low = mid;
                }
            } else if (isPivotRight && !isPivotLeft) {
                if (target <= nums[mid] && target >= nums[low]) {
                    max = mid;
                } else {
                    low = mid;
                }
            } else {
                if (target >= nums[mid] && target <= nums[low]) {
                    low = mid;
                } else {
                    max = mid;
                }
            }
        }


        if (nums[low] == target) {
            return low;
        }

        if (nums[max] == target) {
            return max;
        }

        return -1;
    }

    private boolean isPivot(int low, int max, int[] nums) {
        return nums[low] > nums[max];
    }
}

