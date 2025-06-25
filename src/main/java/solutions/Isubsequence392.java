package solutions;

public class Isubsequence392 {
    public boolean isSubsequence(String s, String t) {
        if(s.isEmpty()) {
            return true;
        }

        int startS = 0;
        int startT = 0;

        while(startS<s.length() && startT<t.length()){
            if(t.charAt(startT) == s.charAt(startS)) {
                startT++;
                startS++;
            } else {
                startT++;
            }
        }

        return startS>=s.length();
    }
}
