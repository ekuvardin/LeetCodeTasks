package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*

        MergeIntervals56 mergeIntervals56 = new MergeIntervals56();
        mergeIntervals56.merge(new int [][] {{1,4},{0,4}});
Yandex
 */
public class MergeIntervals56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (o1, o2) -> {
            if (o1[0] < o2[0]) {
                return -1;
            } else if (o1[0] > o2[0]) {
                return 1;
            }
            return 0;
        });

        int min = intervals[0][0];
        int max = intervals[0][1];

        List<Integer> lstMin = new ArrayList<>();
        List<Integer> lstMax = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= max) {
                if (max < intervals[i][1]) {
                    max = intervals[i][1];
                }
            } else if (max < intervals[i][0]) {
                lstMin.add(min);
                lstMax.add(max);
                min = intervals[i][0];
                max = intervals[i][1];
            }
        }

        lstMin.add(min);
        lstMax.add(max);

        int[][] result = new int[lstMin.size()][2];
        for (int i = 0; i < lstMin.size(); i++) {
            int[] tmp = new int[2];
            tmp[0] = lstMin.get(i);
            tmp[1] = lstMax.get(i);
            result[i] = tmp;
        }

        return result;
    }
}
