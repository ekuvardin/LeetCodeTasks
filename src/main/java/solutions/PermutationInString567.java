package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/*
yandex
 */
public class PermutationInString567 {

    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) return false;

        Map<Character, Integer> maps1 = new HashMap<>();
        Map<Character, Integer> maps2 = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            maps1.put(s1.charAt(i), maps1.getOrDefault(s1.charAt(i), 0) + 1);
            maps2.put(s2.charAt(i), maps2.getOrDefault(s2.charAt(i), 0) + 1);
        }

        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (matches(maps1, maps2)) return true;

            maps2.put(s2.charAt(i), maps2.get(s2.charAt(i)) - 1);
            char newKey = s2.charAt(i + s1.length());
            maps2.put(newKey, maps2.getOrDefault(newKey, 0) + 1);
        }

        return matches(maps1, maps2);
    }

    public boolean matches(Map<Character, Integer> maps1, Map<Character, Integer> maps2) {
        for (Map.Entry<Character, Integer> entry : maps1.entrySet()) {
            if (maps2.get(entry.getKey()) == null || !Objects.equals(maps2.get(entry.getKey()), entry.getValue())) {
                return false;
            }
        }
        return true;
    }
}
