package solutions;

/*

 LongestSubarrayof1493 longestSubarrayof1493 = new LongestSubarrayof1493();
        longestSubarrayof1493.longestSubarray(new int[] {1,1,1});

Yandex
 */
public class LongestSubarrayof1493 {
    public int longestSubarray(int[] nums) {
        int curOneCount = 0;
        int prevOneCount = 0;

        int max = -1;

        for (int num : nums) {
            if (num == 0) {
                max = Math.max(max, prevOneCount + curOneCount);
                prevOneCount = curOneCount;
                curOneCount = 0;
            } else {
                curOneCount++;
            }
        }

        if(max == -1) {
            return curOneCount - 1;
        }

        if(max == 0 && curOneCount == 0) {
            return 0;
        }

        return Math.max(max, prevOneCount + curOneCount);
    }
}
