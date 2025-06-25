package solutions;

public class PlusOne66 {

    public int[] plusOne(int[] digits) {

        int i = digits.length - 1;
        int diff = 1;
        while(i>=0 && diff > 0) {
            if(digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                diff = 0;
            }
            i--;
        }

        if(diff == 0) {
            return digits;
        } else {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            for(i=1;i<digits.length + 1; i++) {
                res[i] = digits[i-1];
            }

            return res;
        }
    }
}
