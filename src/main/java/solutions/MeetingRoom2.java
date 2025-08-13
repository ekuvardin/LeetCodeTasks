package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*
 [[0, 30],[5, 10],[15, 20]], return 2.
 */
public class MeetingRoom2 {
    public int minMeetingRooms(int[][] intervals) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));

        int result = 0;
        for (int[] interval : intervals) {
            queue.add(interval[1]);
            if (interval[0] < queue.peek()) {
                result++;
            } else {
                queue.poll();
            }
        }

        return result;
    }


}
