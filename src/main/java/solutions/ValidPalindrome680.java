package solutions;

/*
yandex
 */
public class ValidPalindrome680 {

    public boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(leftChar != rightChar){
                return isPalindrome(s,left+1,right) || isPalindrome(s,left,right-1);
            }
            left++;
            right--;
        }
        return true;
    }
    public static boolean isPalindrome(String s, int left, int right){
        while(left<right){
            if(s.charAt(left) != s.charAt(right))
                return false;
            left++;
            right--;
        }
        return true;
    }
}
