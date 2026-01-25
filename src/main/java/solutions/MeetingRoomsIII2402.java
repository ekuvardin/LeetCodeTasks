package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class MeetingRoomsIII2402 {

    int currentReservedRooms = 0;
    int[] countReserved;
    TreeSet<Integer> reservedRooms;
    Map<long[], Integer> mapMeetingToRoom;
    TreeMap<Long, List<long[]>> sortedRoomsInReserveSortByEnd;
    int pointer = 0;
    long lastTimeRemoved = 0;
    long[] val;

    public int mostBooked(int n, int[][] meetings) {
        countReserved = new int[n];

        reservedRooms = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            reservedRooms.add(i);
        }

        mapMeetingToRoom = new HashMap<>();

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        sortedRoomsInReserveSortByEnd = new TreeMap<>();

        val = iterateMeeting(meetings);

        while (pointer < meetings.length) {
            if (val[0] < lastTimeRemoved) {
                long diff = val[1] - val[0];
                val[0] = lastTimeRemoved;
                val[1] = lastTimeRemoved + diff;
            }

            long[] firstToEndFormReserved = new long[0];
            if (!sortedRoomsInReserveSortByEnd.isEmpty()) {
                Map.Entry<Long, List<long[]>> firstEntryFromReservedToLeave = sortedRoomsInReserveSortByEnd.firstEntry();
                List<long[]> list = firstEntryFromReservedToLeave.getValue();
                firstToEndFormReserved = list.get(0);

                // iterate while
                while (val[0] >= firstToEndFormReserved[1]) {
                    freeLastEntry();

                    if (sortedRoomsInReserveSortByEnd.isEmpty()) {
                        break;
                    }
                    firstEntryFromReservedToLeave = sortedRoomsInReserveSortByEnd.firstEntry();
                    list = firstEntryFromReservedToLeave.getValue();
                    firstToEndFormReserved = list.get(0);
                }
            }

            // Can't free any room before new event start
            if (currentReservedRooms >= n) {
                long diff = val[1] - val[0];
                lastTimeRemoved = firstToEndFormReserved[1];
                val[0] = firstToEndFormReserved[1];
                val[1] = firstToEndFormReserved[1] + diff;
            } else {
                // add new reserve
                addNewEntry(val);
                if (pointer < meetings.length) {
                    val = iterateMeeting(meetings);
                }
            }
        }

        int max = 0, idx = 0;
        for (int i = 0; i < n; i++) {
            if (countReserved[i] > max) {
                max = countReserved[i];
                idx = i;
            }
        }

        return idx;
    }

    private void freeLastEntry() {
        Map.Entry<Long, List<long[]>> firstEntryFromReservedToLeave = sortedRoomsInReserveSortByEnd.firstEntry();
        List<long[]> list = firstEntryFromReservedToLeave.getValue();
        long[] firstToEndFormReserved = list.get(0);

        list.remove(0);
        if (list.isEmpty()) {
            sortedRoomsInReserveSortByEnd.remove(firstEntryFromReservedToLeave.getKey());
        }
        currentReservedRooms--;
        int indexToRelease = mapMeetingToRoom.remove(firstToEndFormReserved);
        reservedRooms.add(indexToRelease);
    }

    private long[] iterateMeeting(int[][] meetings) {
        long[] v = new long[2];
        v[0] = meetings[pointer][0];
        v[1] = meetings[pointer][1];
        return v;
    }

    private void addNewEntry(long[] val) {
        List<long[]> treeSet = sortedRoomsInReserveSortByEnd.getOrDefault(val[1], new LinkedList<>());
        if (treeSet.isEmpty()) {
            sortedRoomsInReserveSortByEnd.put(val[1], treeSet);
        }

        treeSet.add(val);
        pointer++;

        currentReservedRooms++;

        int firstReservedRoom = reservedRooms.first();
        reservedRooms.remove(firstReservedRoom);
        countReserved[firstReservedRoom]++;
        mapMeetingToRoom.put(val, firstReservedRoom);
    }
}
