package solutions;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/*
yandex
 */
public class TopKFrequentWords692 {

    public List<String> topKFrequent(String[] words, int k) {
        final HashMap<String, Integer> map = new HashMap<>();

        for (String word : words) {
            Integer count = map.get(word);
            if (count == null) {
                map.put(word, 1);
            } else {
                map.put(word, count + 1);
            }
        }


        final Map<Integer, Set<String>> set = new TreeMap<>(Comparator.reverseOrder());

        for (Map.Entry<String, Integer> word : map.entrySet()) {
            if (set.containsKey(word.getValue())) {
                Set<String> str = set.get(word.getValue());
                str.add(word.getKey());
            } else {
                Set<String> str = new TreeSet<>();
                str.add(word.getKey());
                set.put(word.getValue(), str);
            }
        }

        Set<Map.Entry<Integer, Set<String>>> collection = set.entrySet();
        List<String> res = new ArrayList<>(k);
        int i = 0;
        for (Map.Entry<Integer, Set<String>> s : collection) {
            for (String m : s.getValue()) {
                if (i >= k) {
                    break;
                }
                res.add(m);
                i++;
            }
        }

        return res;
    }
}
