package solutions;

public class MoveZeroesMove283 {
    public void moveZeroes(int[] nums) {
        int zeroCounts = 0;

        for(int i=0;i<nums.length;i++) {
            if(nums[i] == 0) {
                zeroCounts++;
            } else {
                nums[i - zeroCounts] = nums[i];
            }
        }

        for(int i = nums.length - zeroCounts; i<nums.length;i++) {
            nums[i]=0;
        }
    }
}
