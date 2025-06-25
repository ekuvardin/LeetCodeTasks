package solutions;

public class FindFirstLastInSrotedSetTinkoff {

    public int[] searchRange(int[] nums, int target) {
        if(nums.length == 0) {
            return new int[]{-1,-1};
        }

        if(nums.length == 1) {
            return nums[0] == target ? new int[]{0,0} : new int[]{-1,-1};
        }

        int lower = 0;
        int high = nums.length - 1;
        int mid = (high - lower) /2;
        while(high - lower > 1) {
            if(nums[mid] > target) {
                high = mid;
            } else if(nums[mid] < target) {
                lower = mid;
            } else {
                break;
            }
            mid = lower + (high-lower)/2;
        }

        if(nums[mid] == target) {
            return searchInRange(nums, target, mid);
        } else if(nums[lower] == target) {
            return searchInRange(nums, target, lower);
        }else if(nums[high] == target) {
            return searchInRange(nums, target, high);
        }  else {
            return new int[]{-1,-1};
        }
    }

    private int[] searchInRange(int[] nums, int target, int pointer) {
        int[] result = new int[2];

        for(int i = pointer; i>=0 && nums[i] == target; i--) {
            result[0] = i;
        }

        for(int i = pointer; i<nums.length && nums[i] == target; i++) {
            result[1] = i;
        }

        return result;
    }

}