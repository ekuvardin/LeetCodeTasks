package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*

        GroupAnagrams49 groupAnagrams49 = new GroupAnagrams49();
        groupAnagrams49.groupAnagrams(new String[] {"eat","tea","tan","ate","nat","bat"});
Yandex
 */
public class GroupAnagrams49 {

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>(strs.length);

        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);

            String key = new String(chars);
            List<String> value = map.get(key);
            if (value == null) {
                map.put(key, new ArrayList<>(List.of(str)));
            } else {
                value.add(str);
            }
        }

        return new ArrayList<>(map.values());
    }
}
