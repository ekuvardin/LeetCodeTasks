package solutions;

/*
yandex
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
