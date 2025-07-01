package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Given two strings s and p, return an array of all the start indices of p's

in s. You may return the answer in any order.



Example 1:

Input: s = "cbaebabacd", p = "abc"
Output: [0,6]
Explanation:
The substring with start index = 0 is "cba", which is an anagram of "abc".
The substring with start index = 6 is "bac", which is an anagram of "abc".

Example 2:

Input: s = "abab", p = "ab"
Output: [0,1,2]
Explanation:
The substring with start index = 0 is "ab", which is an anagram of "ab".
The substring with start index = 1 is "ba", which is an anagram of "ab".
The substring with start index = 2 is "ab", which is an anagram of "ab".



Constraints:

    1 <= s.length, p.length <= 3 * 104
    s and p consist of lowercase English letters.


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

            letters[s.charAt(i - p.length() + 1) - 'a']--;
        }

        return result;
    }
}
