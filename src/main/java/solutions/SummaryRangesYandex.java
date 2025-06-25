package solutions;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
Input: nums = [0,1,2,4,5,7]
Output: ["0->2","4->5","7"]
Explanation: The ranges are:
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"
 */
public class SummaryRangesYandex {
    public List<String> summaryRanges(int[] nums) {
        List<String> result = new ArrayList<>();

        if(nums.length == 0) {
            return result;
        }

        Stack<Integer> stack = new Stack<>();
        stack.add(nums[0]);
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (prev != nums[i] - 1) {
                result.add(getBuildString(stack, prev));
                stack.add(nums[i]);
            }

            prev = nums[i];
        }

        result.add(getBuildString(stack, prev));

        return result;
    }

    private String getBuildString(Stack<Integer> stack, int prev) {
        int firstValue = stack.pop();
        StringBuilder pair = new StringBuilder();
        if (firstValue == prev) {
            pair.append(prev);
        } else {
            pair.append(firstValue);
            pair.append("->");
            pair.append(prev);
        }
        return pair.toString();
    }
}
