package solutions;

import java.util.HashMap;
import java.util.Map;

public class FractiontoRecurringDecimal166 {
    public String fractionToDecimal(int numerator, int denominator) {
        int sign = 1;
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            sign = -1;
        }


        long num = Math.abs(Long.valueOf(denominator));
        long dem = Math.abs(Long.valueOf(denominator));


        if (num == 0) {
            return "0";
        }

        StringBuilder result = new StringBuilder();


        if (sign == -1) {
            result.insert(0, "-");
        }


        result.append(num / dem);
        long remainder = num % dem;
        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");
        Map<Long, Integer> map = new HashMap<>();
        while (remainder != 0) {
            if (map.containsKey(remainder)) {
                result.insert(map.get(remainder), "(");
                result.append(")");
                break;
            }
            map.put(remainder, result.length());
            remainder = remainder * 10;
            result.append(remainder / dem);
            remainder %= dem;
        }

        return result.toString();
    }
}
