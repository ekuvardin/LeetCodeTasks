package solutions;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/*
yandex
  l.intervalIntersection(new int[][]{ {0,2}, {5,10}, {13,23}, {24,25}}, new int[][]{ {1,5}, {8,12}, {15,24}, {25,26}});
 */
public class IntervalListIntersections986 {
    public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
        if (firstList.length == 0 || secondList.length == 0) {
            return new int[0][0];
        }

        PriorityQueue<Point> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.start));

        for (int[] value : firstList) {
            queue.add(new Point(value[0], value[1]));
        }

        for (int[] value : secondList) {
            queue.add(new Point(value[0], value[1]));
        }

        Point temp = queue.poll();
        int start = temp.start;
        int end = temp.end;

        List<Point> points = new ArrayList<>();
        while (!queue.isEmpty()) {
            temp = queue.poll();
            if (temp.start >= start && temp.start <= end) {
                if (temp.end > end) {
                    points.add(new Point(temp.start, end));
                    start = end;
                    end = temp.end;
                } else {
                    points.add(new Point(temp.start, temp.end));
                    start = temp.end;
                }
            } else {
                start = temp.start;
                end = temp.end;
            }
        }

        int[][] res = new int[points.size()][2];
        for (int i = 0; i < points.size(); i++) {
            res[i][0] = points.get(i).start;
            res[i][1] = points.get(i).end;
        }

        return res;
    }

    public static class Point {
        int start;
        int end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
