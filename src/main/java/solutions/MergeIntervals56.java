package solutions;

import java.nio.channels.Pipe;
import java.util.*;

/*

       Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.



Example 1:

Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
Output: [[1,6],[8,10],[15,18]]
Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].

Example 2:

Input: intervals = [[1,4],[4,5]]
Output: [[1,5]]
Explanation: Intervals [1,4] and [4,5] are considered overlapping.



Constraints:

    1 <= intervals.length <= 104
    intervals[i].length == 2
    0 <= starti <= endi <= 104


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

    public int[][] merge2(int[][] intervals) {
        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.x));

        for (int[] interval : intervals) {
            queue.add(new Point(interval[0], interval[1]));
        }

        Point point = queue.poll();
        int min = point.x;
        int max = point.y;

        List<Integer> lstMin = new ArrayList<>();
        List<Integer> lstMax = new ArrayList<>();

        while(!queue.isEmpty()) {
            Point temp = queue.poll();
            if(temp.x <= max) {
                if(max < temp.y) {
                    max = temp.y;
                }
            } else {
                lstMin.add(min);
                lstMax.add(max);
                min = temp.x;
                max = temp.y;
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

    public static class Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
