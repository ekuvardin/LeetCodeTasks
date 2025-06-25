package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/*
yandex
   ReconstructItinerary332 l = new ReconstructItinerary332();
        List<List<String>> tickets = new ArrayList<>();

        tickets.add(List.of("MUC","LHR"));
   0    tickets.add(List.of("JFK","MUC"));
        tickets.add(List.of("SFO","SJC"));
        tickets.add(List.of("LHR","SFO"));


        tickets.add(List.of("JFK","SFO"));
        tickets.add(List.of("JFK","ATL"));
        tickets.add(List.of("SFO","ATL"));
        tickets.add(List.of("ATL","JFK"));
        tickets.add(List.of("ATL","SFO"));

        l.findItinerary(tickets);
 */
public class ReconstructItinerary332 {
    public List<String> findItinerary(List<List<String>> tickets) {
        Map<String, PriorityQueue<String>> map = new HashMap<>();

        for (List<String> temp : tickets) {
            PriorityQueue<String> val = map.computeIfAbsent(temp.get(0), k -> new PriorityQueue<>());
            val.add(temp.get(1));
        }

        Stack<String> queue = new Stack<>();
        queue.add("JFK");
        LinkedList<String> result = new LinkedList<>();

        while (!queue.isEmpty()) {
            String destination = queue.peek();
            if (map.containsKey(destination) && !map.get(destination).isEmpty()) {
                queue.add(map.get(destination).poll());
            } else {
                result.addFirst(queue.pop());
            }
        }

        return result;
    }
}
