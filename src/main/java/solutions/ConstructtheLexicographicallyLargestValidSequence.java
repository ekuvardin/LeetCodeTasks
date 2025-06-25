package solutions;

/*
 ConstructtheLexicographicallyLargestValidSequence reverseString = new ConstructtheLexicographicallyLargestValidSequence();
        reverseString.constructDistancedSequence(5);
 */
public class ConstructtheLexicographicallyLargestValidSequence {

    public int[] constructDistancedSequence(int n) {
        int[] result;
        if (n == 1) {
            result = new int[1];
            result[0] = 1;
        } else {
            result = new int[2 * n - 1];
            boolean[] used = new boolean[n + 1];
            backtrack(result, used, n, 0);
        }

        return result;
    }

    public boolean backtrack(int[] result, boolean[] used, int n, int idx) {
        while (idx < result.length && result[idx] != 0) {
            idx++;
        }

        if (idx == result.length) {
            return true;
        }

        for (int i = n; i >= 1; i--) {
            if (used[i]) continue;


            if (i == 1) {
                result[idx] = 1;
                used[1] = true;
                if (backtrack(result, used, n, idx + 1)) return true;
                result[idx] = 0;
                used[1] = false;
            } else {
                if (idx + i < result.length && result[idx + i] == 0) {
                    result[idx] = i;
                    result[idx + i] = i;
                    used[i] = true;
                    if (backtrack(result, used, n, idx + 1)) return true;
                    result[idx] = 0;
                    result[idx + i] = 0;
                    used[i] = false;
                }

            }

        }
        return false;
    }
}
