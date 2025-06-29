package solutions;

/*
yandex

Description

Given two strings s and t, return true if the two strings are anagrams of each other, otherwise return false.

An anagram is a string that contains the exact same characters as another string, but the order of the characters can be different.

Example 1:

Input: s = "racecar", t = "carrace"

Output: true

Example 2:

Input: s = "jar", t = "jam"

Output: false

Constraints:
 */
public class ValidAnagram242 {
    public boolean isAnagram(String s, String t) {
        int[] letters = new int[26];

        if (s.length() != t.length()) {
            return false;
        }

        for (int i = 0; i < s.length(); i++) {
            int pointer = s.charAt(i) - 'a';
            letters[pointer] = letters[pointer] + 1;
        }

        for (int i = 0; i < t.length(); i++) {
            int pointer = t.charAt(i) - 'a';
            letters[pointer] = letters[pointer] - 1;
        }

        for (int i = 0; i < 26; i++) {
            if (letters[i] != 0) {
                return false;
            }
        }

        return true;
    }
}
