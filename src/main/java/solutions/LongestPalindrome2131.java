package solutions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestPalindrome2131 {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        Set<String> processed = new HashSet<>();
        boolean hasSymmetricOnlyOne = false;

        for (String word : words) {
            Integer cnt = map.get(word);
            if (cnt == null) {
                map.put(word, 1);
            } else {
                map.put(word, cnt + 1);
            }
        }

        int res = 0;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            int cnt1 = entry.getValue();
            String word1 = entry.getKey();
            String word2 = new StringBuilder(word1).reverse().toString();

            if(processed.contains(word1)) {
                continue;
            }

            if(word1.charAt(1) == word1.charAt(0)) {
                if(!hasSymmetricOnlyOne) {
                    res += cnt1 * 2;
                    if(cnt1 % 2 != 0) {
                        hasSymmetricOnlyOne = true;
                    }
                } else {
                    if(cnt1 % 2 == 0) {
                        res += cnt1 * 2;
                    } else {
                        res += (cnt1 - 1) * 2;
                    }
                }
                processed.add(word1);
            } else {
                int cnt2 = map.getOrDefault(word2, 0);
                res += Math.min(cnt1, cnt2) * 4;
                processed.add(word1);
                processed.add(word2);
            }
        }

        return res;
    }
}
