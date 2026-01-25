package solutions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Booked1 {

    int plusTime = 0;
    int[] countReserved;
    TreeSet<Integer> reservedRooms;
    Map<int[], Integer> reserRooms;
    TreeMap<Integer, int[]> sortedRoomsInReserveSortByStart;
    TreeMap<Integer, List<int[]>> sortedRoomsInReserveSortByEnd;
    int currentReservedRooms = 0;

    int pointer = 0;

    public Booked1(int n, int[][] meetings) {

        countReserved = new int[n];


        reservedRooms = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            reservedRooms.add(i);
        }

        reserRooms = new HashMap<>();

        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));

        sortedRoomsInReserveSortByStart = new TreeMap<>();
        sortedRoomsInReserveSortByEnd = new TreeMap<>();

    }

    public int iterate(int n, int[][] meetings) {

        if (pointer < meetings.length) {
            int[] val = meetings[pointer];

            if (plusTime > val[0]) {
                int diff = val[1] - val[0];
                val[0] = plusTime;
                val[1] = plusTime + diff;
            } else {
                plusTime = 0;
            }

            if (sortedRoomsInReserveSortByStart.isEmpty()) {
                sortedRoomsInReserveSortByStart.put(val[0], val);
                List<int[]> treeSet = sortedRoomsInReserveSortByEnd.getOrDefault(val[1], new LinkedList<>());
                if (treeSet.isEmpty()) {
                    sortedRoomsInReserveSortByEnd.put(val[1], treeSet);
                }

                treeSet.add(val);
                pointer++;
                currentReservedRooms++;

                int firstReservedRoom = reservedRooms.first();
                reservedRooms.remove(firstReservedRoom);
                countReserved[firstReservedRoom]++;
                reserRooms.put(val, firstReservedRoom);
            } else {
                Map.Entry<Integer, List<int[]>> entry = sortedRoomsInReserveSortByEnd.firstEntry();
                List<int[]> list = entry.getValue();
                int[] firstToEndFormReserved = list.get(0);

                if (val[0] >= firstToEndFormReserved[1] || currentReservedRooms >= n) {
                    if (currentReservedRooms >= n && val[0] < firstToEndFormReserved[1]) {
                        plusTime = firstToEndFormReserved[1];
                    }

                    list.remove(0);
                    if (list.isEmpty()) {
                        sortedRoomsInReserveSortByEnd.remove(entry.getKey());
                    }
                    sortedRoomsInReserveSortByStart.remove(firstToEndFormReserved[0]);
                    currentReservedRooms--;
                    int indexToRelease = reserRooms.remove(firstToEndFormReserved);
                    reservedRooms.add(indexToRelease);

                } else { //  currentReservedRooms < n
                    sortedRoomsInReserveSortByStart.put(val[0], val);
                    List<int[]> treeSet = sortedRoomsInReserveSortByEnd.getOrDefault(val[1], new LinkedList<>());
                    if (treeSet.isEmpty()) {
                        sortedRoomsInReserveSortByEnd.put(val[1], treeSet);
                    }

                    treeSet.add(val);
                    pointer++;
                    currentReservedRooms++;

                    int firstReservedRoom = reservedRooms.first();
                    reservedRooms.remove(firstReservedRoom);
                    countReserved[firstReservedRoom]++;
                    reserRooms.put(val, firstReservedRoom);
                }
            }
            return 1;
        }
        return  -1;
/*
        int max = 0, idx = 0;
        for (int i = 0; i < n; i++) {
            if (countReserved[i] > max) {
                max = countReserved[i];
                idx = i;
            }
        }

        return idx;*/
    }
}
