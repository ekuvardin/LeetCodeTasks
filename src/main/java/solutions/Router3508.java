package solutions;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.TreeMap;

/*
Design a data structure that can efficiently manage data packets in a network router. Each data packet consists of the following attributes:

    source: A unique identifier for the machine that generated the packet.
    destination: A unique identifier for the target machine.
    timestamp: The time at which the packet arrived at the router.

Implement the Router class:

Router(int memoryLimit): Initializes the Router object with a fixed memory limit.

    memoryLimit is the maximum number of packets the router can store at any given time.
    If adding a new packet would exceed this limit, the oldest packet must be removed to free up space.

bool addPacket(int source, int destination, int timestamp): Adds a packet with the given attributes to the router.

    A packet is considered a duplicate if another packet with the same source, destination, and timestamp already exists in the router.
    Return true if the packet is successfully added (i.e., it is not a duplicate); otherwise return false.

int[] forwardPacket(): Forwards the next packet in FIFO (First In First Out) order.

    Remove the packet from storage.
    Return the packet as an array [source, destination, timestamp].
    If there are no packets to forward, return an empty array.

int getCount(int destination, int startTime, int endTime):

    Returns the number of packets currently stored in the router (i.e., not yet forwarded) that have the specified destination and have timestamps in the inclusive range [startTime, endTime].

Note that queries for addPacket will be made in increasing order of timestamp.



Example 1:

Input:
["Router", "addPacket", "addPacket", "addPacket", "addPacket", "addPacket", "forwardPacket", "addPacket", "getCount"]
[[3], [1, 4, 90], [2, 5, 90], [1, 4, 90], [3, 5, 95], [4, 5, 105], [], [5, 2, 110], [5, 100, 110]]

Output:
[null, true, true, false, true, true, [2, 5, 90], true, 1]

Explanation
Router router = new Router(3); // Initialize Router with memoryLimit of 3.
router.addPacket(1, 4, 90); // Packet is added. Return True.
router.addPacket(2, 5, 90); // Packet is added. Return True.
router.addPacket(1, 4, 90); // This is a duplicate packet. Return False.
router.addPacket(3, 5, 95); // Packet is added. Return True
router.addPacket(4, 5, 105); // Packet is added, [1, 4, 90] is removed as number of packets exceeds memoryLimit. Return True.
router.forwardPacket(); // Return [2, 5, 90] and remove it from router.
router.addPacket(5, 2, 110); // Packet is added. Return True.
router.getCount(5, 100, 110); // The only packet with destination 5 and timestamp in the inclusive range [100, 110] is [4, 5, 105]. Return 1.

Example 2:

Input:
["Router", "addPacket", "forwardPacket", "forwardPacket"]
[[2], [7, 4, 90], [], []]

Output:
[null, true, [7, 4, 90], []]

Explanation
Router router = new Router(2); // Initialize Router with memoryLimit of 2.
router.addPacket(7, 4, 90); // Return True.
router.forwardPacket(); // Return [7, 4, 90].
router.forwardPacket(); // There are no packets left, return [].



Constraints:

    2 <= memoryLimit <= 105
    1 <= source, destination <= 2 * 105
    1 <= timestamp <= 109
    1 <= startTime <= endTime <= 109
    At most 105 calls will be made to addPacket, forwardPacket, and getCount methods altogether.
    queries for addPacket will be made in increasing order of timestamp.


 */
public class Router3508 {
    private final int memoryLimit;
    private final Set<Packet> packets;
    private final TreeMap<Integer, List<Packet>> allPackets;
    private final Map<Integer, List<Integer>> destinations;

    public Router3508(int memoryLimit) {
        this.memoryLimit = memoryLimit;
        packets = new HashSet<>(memoryLimit);
        allPackets = new TreeMap<>();
        destinations = new TreeMap<>();
    }

    public boolean addPacket(int source, int destination, int timestamp) {
        Packet packet = new Packet(source, destination, timestamp);
        if (packets.contains(packet)) {
            return false;
        } else {
            packets.add(packet);
            List<Packet> temp = allPackets.getOrDefault(timestamp, new LinkedList<>());
            if (temp.isEmpty()) {
                allPackets.put(timestamp, temp);
            }

            temp.add(packet);

            List<Integer> list = destinations.getOrDefault(destination, new ArrayList<>());
            if (list.isEmpty()) {
                destinations.put(destination, list);
            }
            list.add(timestamp);


            if (packets.size() > memoryLimit) {
                removePacket();
            }

            return true;
        }
    }

    public int[] forwardPacket() {
        if (packets.isEmpty()) {
            return new int[0];
        } else {
            Packet packet = removePacket();
            return new int[]{packet.source, packet.destination, packet.timestamp};
        }
    }

    private Packet removePacket() {
        Map.Entry<Integer, List<Packet>> entry = allPackets.firstEntry();
        Packet packet = entry.getValue().get(0);
        if (entry.getValue().size() == 1) {
            allPackets.remove(packet.timestamp);
        } else {
            entry.getValue().remove(0);
        }

        List<Integer> set = destinations.get(packet.destination);
        set.remove(0);
        if (set.isEmpty()) {
            destinations.remove(packet.destination);
        }

        packets.remove(packet);
        return packet;
    }

    public int getCount(int destination, int startTime, int endTime) {
        final List<Integer> list = destinations.get(destination);
        if (list == null || list.isEmpty())
            return 0;

        final int left = lowerBound(list, startTime);
        final int right = upperBound(list, endTime);

        return right - left;
    }

    private int lowerBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while (low < high) {
            final int mid = (low + high) >>> 1;
            if (list.get(mid) < target) low = mid + 1;
            else high = mid;
        }

        return low;
    }

    private int upperBound(final List<Integer> list, final int target) {
        int low = 0, high = list.size();

        while (low < high) {
            final int mid = (low + high) >>> 1;

            if (list.get(mid) <= target)
                low = mid + 1;
            else
                high = mid;
        }

        return low;
    }

    public static class Packet {
        int source;
        int destination;
        int timestamp;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Packet packet = (Packet) o;
            return source == packet.source && destination == packet.destination && timestamp == packet.timestamp;
        }

        @Override
        public int hashCode() {
            return Objects.hash(source, destination, timestamp);
        }

        public Packet(int source, int destination, int timestamp) {
            this.source = source;
            this.destination = destination;
            this.timestamp = timestamp;
        }
    }
}