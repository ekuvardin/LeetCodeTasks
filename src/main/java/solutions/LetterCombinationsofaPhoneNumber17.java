package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber17 {
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Integer, List<Character>> map = new HashMap<>(8);
        map.put(2, Arrays.asList('a', 'b', 'c'));
        map.put(3, Arrays.asList('d', 'e', 'f'));
        map.put(4, Arrays.asList('g', 'h', 'i'));
        map.put(5, Arrays.asList('j', 'k', 'l'));
        map.put(6, Arrays.asList('m', 'n', 'o'));
        map.put(7, Arrays.asList('p', 'q', 'r', 's'));
        map.put(8, Arrays.asList('t', 'u', 'v'));
        map.put(9, Arrays.asList('w', 'x', 'y', 'z'));

        List<String> res = new ArrayList<>();

        int[] counter = new int[digits.length()];
        int stop = map.get(digits.charAt(0) - '0').size();

        while (counter[0] < stop) {
            StringBuilder temp = new StringBuilder();
            for (int i = 0; i < digits.length(); i++) {
                temp.append(map.get( digits.charAt(i) - '0').get(counter[i]));
            }

            res.add(temp.toString());

            for (int i = digits.length() - 1; i >=0; i--) {
                int tp = counter[i];
                List<Character> v = map.get(digits.charAt(i) - '0');
                if (tp < v.size() - 1) {
                    counter[i] = counter[i] + 1;
                    break;
                } else {
                    if (i == 0) {
                        counter[i] = counter[i] + 1;
                    } else {
                        counter[i] = 0;
                    }
                }
            }
        }

        return res;
    }
}
