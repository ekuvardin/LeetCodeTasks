package solutions;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
yandex

     MinimumWindowSubstring76 l = new MinimumWindowSubstring76();
        l.minWindow("EERADOBECODEBANCC", "ABCC");

 */
public class MinimumWindowSubstring76 {

    public String minWindow(String s, String t) {

        if (t.length() > s.length()) {
            return "";
        }

        int start = 0;
        int end = 0;

        String substring = "";


        Map<Character, Integer> map = new HashMap<>(t.length());

        for (int i = 0; i < t.length(); i++) {
            Integer count = map.get(t.charAt(i));
            if (count == null) {
                map.put(t.charAt(i), 1);
            } else {
                map.put(t.charAt(i), count + 1);
            }
        }
        int counter = map.size();
        int foundLength = -1;
        int head = -1;

        while (start <= end && start < s.length() && map.get(s.charAt(start)) == null) {
            start++;
            end++;
        }

        while (end < s.length()) {
            char curValue = s.charAt(end);

            if (map.containsKey(curValue)) {
                map.put(curValue, map.get(curValue) - 1);
                if (map.get(curValue) == 0) {
                    counter--;
                }
            }

            end++;

            while (counter == 0) {
                curValue = s.charAt(start);

                if (map.containsKey(curValue)) {
                    map.put(curValue, map.get(curValue) + 1);
                    if (map.get(curValue) > 0) {
                        counter++;
                    }
                }

                if (foundLength == -1 || end - start < foundLength) {
                    foundLength = end - start;
                    head = start;
                }
                start++;
            }
        }

        return foundLength == -1 ? "" : s.substring(head, head + foundLength);
    }

}
