package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

public class MasTwoEvents {

    public static int maxTwoEvents(int[][] events) {
        int n = events.length;

        Arrays.sort(events, Comparator.comparingInt(a -> a[1]));

        int[] ends = new int[n], max_single = new int[n];

        for (int i = 0; i < n; i++) {
            ends[i] = events[i][1];
            max_single[i] = events[i][2];

            if (i > 0) {
                max_single[i] = Math.max(max_single[i - 1], events[i][2]);
            }
        }

        int ans = max_single[n - 1];

        for (int i = 0; i < n; i++) {
            int start = events[i][0];
            int value = events[i][2];

            int j1 = lookBackward(ends, start, i);
            int j2 = binarySearch(ends, start, i);


            if (j2 != -1) {
                ans = Math.max(ans, value + max_single[j2]);
            }
        }

        return ans;
    }

    public static int lookBackward(int[] ends, int target, int right) {
        int res = -1;

        for (int i = right - 1; i >= 0; i--) {
            if (ends[i] < target) {
                return i;
            }
        }
        return res;
    }


    public static int binarySearch(int[] ends, int target, int right) {
        int left = 0;
        int res = -1;

        while (left < right) {
            int mid = (left + right) / 2;
            if (ends[mid] < target) {
                res = mid;
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return res;

    }

}
