package solutions;

/*
yandex
 */
public class SquaresofaSortedArray977 {

    public int[] sortedSquares(int[] nums) {
        int negPointer = -1;
        int posPointer = nums.length;
        for(int i=0;i<nums.length; i++) {
            if(nums[i] >= 0) {
                posPointer = i;
                break;
            } else {
                negPointer = i;
            }
        }

        int[] res = new int[nums.length];
        int pos = 0;

        while(posPointer < nums.length || negPointer >=0) {
            if(negPointer < 0) {
                res[pos] = nums[posPointer] * nums[posPointer];
                posPointer++;
            } else if(posPointer >= nums.length) {
                res[pos] = nums[negPointer] * nums[negPointer];
                negPointer--;
            } else if(nums[posPointer] <= -nums[negPointer]) {
                res[pos] = nums[posPointer] * nums[posPointer];
                posPointer++;
            } else {
                res[pos] = nums[negPointer] * nums[negPointer];
                negPointer--;
            }

            pos++;
        }

        return res;
    }
}
