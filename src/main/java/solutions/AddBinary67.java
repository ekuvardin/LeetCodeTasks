package solutions;

public class AddBinary67 {
    public String addBinary(String a, String b) {
        String mx;
        String mn;
        if(a.length() >= b.length()) {
            mx = a;
            mn = b;
        } else {
            mx = b;
            mn = a;
        }

        int diff = 0;
        StringBuilder result = new StringBuilder();
        int j = mx.length() - 1;
        for(int i=mn.length() - 1; i>=0; i--, j--) {
            int temp = mn.charAt(i) - '0' + mx.charAt(j) - '0' + diff;
            //  temp == 2 (1+0 + 1)  0
            //   temp == 3 (1+1+1)    1
            result.append(temp % 2);
            diff = temp >= 2 ? 1 : 0;
        }

        for(; j>=0;j--) {
            int temp = mx.charAt(j) - '0' + diff;
            result.append(temp % 2);
            diff = temp >=2 ? 1 : 0;
        }

        if(diff > 0) {
            result.append(1);
        }

        return result.reverse().toString();
    }
}
