package solutions;

import java.util.HashSet;
import java.util.Set;

/*
yandex

Given a string s, find the length of the longest

without duplicate characters.


Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


 */
public class LongestSubstringWithoutRepeatingCharacters3 {

    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }

        Set<Character> set = new HashSet<>();
        int max = 0;
        int curMaxLen = 0;
        int startIndex = 0;

        for (int i = 0; i < s.length(); i++) {
            char newChar = s.charAt(i);
            if (set.contains(newChar)) {
                max = Math.max(max, curMaxLen);
                while (s.charAt(startIndex) != newChar) {
                    set.remove(s.charAt(startIndex));
                    startIndex++;
                    curMaxLen--;
                }
                set.remove(s.charAt(startIndex));
                startIndex++;
                curMaxLen--;
            }
            set.add(newChar);
            curMaxLen++;
        }

        return Math.max(max, curMaxLen);
    }

}
