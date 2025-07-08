package solutions;

public class OneEditDistance161 {
    public boolean isOneEditDistance(String s, String t) {

        int lengthS = s.length(), lengthT = t.length();


        // Ensure s is the longer string.

        if (lengthS < lengthT) {

            return isOneEditDistance(t, s);

        }


        // If the length difference is more than 1, it's not one edit distance.

        if (lengthS - lengthT > 1) {

            return false;

        }


        // Check each character to see if there's a discrepancy.

        for (int i = 0; i < lengthT; ++i) {

            if (s.charAt(i) != t.charAt(i)) {

                // If the lengths are the same, the rest of the strings must be equal after this character.

                if (lengthS == lengthT) {

                    return s.substring(i + 1).equals(t.substring(i + 1));

                }

                // If the lengths are not the same, the rest of the longer string must be equal to the rest of the shorter string after this character.

                return s.substring(i + 1).equals(t.substring(i));

            }

        }


        // Covers the case where there is one extra character at the end of the longer string.

        return lengthS == lengthT + 1;

    }
}
