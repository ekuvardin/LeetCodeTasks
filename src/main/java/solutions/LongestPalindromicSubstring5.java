package solutions;

/*
yandex
 */
public class LongestPalindromicSubstring5 {
    public String longestPalindrome(String s) {
        int maxLength = 0;
        String result = "";

        for(int low = 0; low < s.length(); low++) {
            int max = low;
            while(max < s.length()) {
                if(s.charAt(low) == s.charAt(max)) {
                    String newS = s.substring(low, max + 1);
                    String reverse = new StringBuilder(newS).reverse().toString();

                    if(newS.equals(reverse) && newS.length() > maxLength) {
                        result = newS;
                        maxLength = newS.length();
                    }
                }
                max++;
            }
        }

        return result;
    }
}
