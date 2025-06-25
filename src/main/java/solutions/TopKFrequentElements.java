package solutions;


import java.util.*;
import java.util.function.BiFunction;

/*
  topKFrequentElements.topKFrequent( new int[] {1,1,1,2,2,3} ,2);

 */
public class TopKFrequentElements {

    public int[] topKFrequent(int[] nums, int k) {

        HashMap<Integer, Integer> value = new HashMap<>(nums.length);

        for (int num : nums) {
            value.put(num, value.getOrDefault(num, 0) + 1);
        }

        TreeMap<Integer, Set<Integer>> map = getIntegerSetTreeMap(value);

        int pointer = 0;
        int[] result = new int[k];

        for (Map.Entry<Integer, Set<Integer>> p : map.entrySet()) {
            for (Integer val : p.getValue()) {
                if (pointer < k) {
                    result[pointer] = val;
                    pointer++;
                }
            }
            if (pointer >= k) {
                break;
            }
        }

        return result;
    }

    private static TreeMap<Integer, Set<Integer>> getIntegerSetTreeMap(HashMap<Integer, Integer> value) {
        TreeMap<Integer, Set<Integer>> map = new TreeMap<>(Comparator.reverseOrder());

        for (Map.Entry<Integer, Integer> p : value.entrySet()) {
            if (!map.containsKey(p.getValue())) {
                HashSet<Integer> set = new HashSet<>();
                set.add(p.getKey());
                map.put(p.getValue(), set);
            } else {
                map.computeIfPresent(p.getValue(), (integer, integers) -> {
                    integers.add(p.getKey());
                    return integers;
                });
            }
        }
        return map;
    }
}



