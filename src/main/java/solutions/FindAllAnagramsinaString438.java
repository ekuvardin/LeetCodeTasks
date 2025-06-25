package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
yandex
 */
public class FindAllAnagramsinaString438 {
    public List<Integer> findAnagrams(String s, String p) {
        if (p.length() > s.length()) {
            return new ArrayList<>();
        }

        int[] lettersEtalon = new int[26];
        for (int i = 0; i < p.length(); i++) {
            int index = p.charAt(i) - 'a';
            lettersEtalon[index] = lettersEtalon[index] + 1;
        }

        int[] letters = new int[26];
        int i = 0;
        for (; i < p.length() - 1; i++) {
            int index = s.charAt(i) - 'a';
            letters[index] = letters[index] + 1;
        }

        List<Integer> result = new ArrayList<>();
        for (; i < s.length(); i++) {
            int index = s.charAt(i) - 'a';
            letters[index] = letters[index] + 1;

            if (Arrays.equals(letters, lettersEtalon)) {
                result.add(i - p.length() + 1);
            }

            index = s.charAt(i - p.length() + 1) - 'a';
            letters[index] = letters[index] - 1;
        }

        return result;
    }
}
