package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/*

252. Meeting Rooms

Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 determine if a person could attend all meetings.

Example 1:

Input: [[0,30],[5,10],[15,20]]
Output: false

Example 2:

Input: [[7,10],[2,4]]
Output: true

NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
Difficulty:
 */
public class MeetingRooms1 {
    public boolean canAttendMeetings(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));

        queue.addAll(Arrays.asList(intervals));

        int[] st = queue.poll();

        while (!queue.isEmpty()) {
            int[] temp = queue.poll();
            if (temp[0] < st[1]) {
                return false;
            }

            st = temp;
        }

        return true;
    }
}
