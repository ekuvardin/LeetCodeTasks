package solutions;

import java.util.ArrayList;
import java.util.List;

/*
Problem Description

You need to design a hit counter system that tracks the number of hits received within the past 5 minutes (300 seconds).

The system should support two main operations:

    Recording hits: When a hit occurs at a specific timestamp (in seconds), the system should record it. Multiple hits can happen at the same timestamp.

    Querying hit count: Given a timestamp, the system should return the total number of hits that occurred in the past 300 seconds from that timestamp. Specifically, it counts all hits in the time range [timestamp - 299, timestamp].

Key constraints and assumptions:

    Timestamps are provided in seconds
    Calls to the system happen in chronological order (timestamps are monotonically increasing)
    Multiple hits may arrive at the same timestamp

The HitCounter class needs three methods:

    HitCounter(): Initializes the hit counter system
    hit(timestamp): Records a hit at the given timestamp
    getHits(timestamp): Returns the count of all hits in the past 300 seconds from the given timestamp

For example, if hits occurred at timestamps 1, 2, 3, and 301, calling getHits(301) would return 1 (only the hit at timestamp 301 is within the past 300 seconds), while getHits(303) would still return 1 since the hit at timestamp 1 is now more than 300 seconds old.

The solution uses a list to store all timestamps and binary search (bisect_left) to efficiently find the boundary of the 5-minute window. Since timestamps are monotonically increasing, the list remains sorted, making binary search an optimal approach for finding how many hits fall within the valid time window.
 */
public class DesignHitCounter {

    // List to store all hit timestamps in chronological order

    private final List<Integer>  timestamps;

    public DesignHitCounter() {
        timestamps = new ArrayList<>();
    }

    public void hit(int timestamp) {
        timestamps.add(timestamp);
    }


    public int getHits(int timestamp) {
        int left = search(timestamp - 299);
        return timestamps.size() - left;
    }

    public int search(int timestamp) {
        int left = 0;
        int right = timestamps.size() - 1;

        while(left < right) {
            int mid = (right + left) / 2;

            if(timestamps.get(mid) < timestamp) {
                left = left + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

}

class DesignHitCounterWithUsers {

}
