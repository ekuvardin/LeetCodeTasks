package solutions;

public class MakeStringSubsequenceUsingCyclicIncrements2825 {
    public boolean canMakeSubsequence(String str1, String str2) {
        int idx1 = 0;
        int idx2 = 0;

        while (idx1 < str1.length() && idx2 < str2.length()) {
            if (str1.charAt(idx1) == str2.charAt(idx2) || (str1.charAt(idx1) - 'a' + 1) % 26 == str2.charAt(idx2) - 'a') {
                idx2++;
            }
            if (idx2 == str2.length()) {
                return true;
            }
            idx1++;
        }

        return false;
    }
}
