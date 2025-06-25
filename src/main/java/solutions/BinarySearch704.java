package solutions;

public class BinarySearch704 {
    public int search(int[] nums, int target) {
        int left=0;
        int rigth = nums.length - 1;
        while(left <= rigth-2) {
            if(nums[left] == target) {
                return left;
            }

            if(nums[rigth] == target) {
                return rigth;
            }

            int mid = (left+rigth)/2;
            if(nums[mid]>target) {
                rigth = mid;
            } else {
                left = mid;
            }

        }

        if(nums[left] == target) {
            return left;
        }

        if(nums[rigth] == target) {
            return rigth;
        }

        return -1;
    }
}
