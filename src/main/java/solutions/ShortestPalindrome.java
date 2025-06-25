package solutions;

public class ShortestPalindrome {

    public String shortestPalindrome(String s) {
        final String newPath = new StringBuilder(s).reverse().toString();

        for(int i=0;i<s.length();i++){
            if (s.startsWith(newPath.substring(i))) {
                return newPath.substring(0, i) + s;
            }
        }
        return newPath + s;
    }
}

