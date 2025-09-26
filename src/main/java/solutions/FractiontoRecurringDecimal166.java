package solutions;

import java.util.HashMap;
import java.util.Map;

/*
Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

If the fractional part is repeating, enclose the repeating part in parentheses.

If multiple answers are possible, return any of them.

It is guaranteed that the length of the answer string is less than 104 for all the given inputs.



Example 1:

Input: numerator = 1, denominator = 2
Output: "0.5"

Example 2:

Input: numerator = 2, denominator = 1
Output: "2"

Example 3:

Input: numerator = 4, denominator = 333
Output: "0.(012)"



Constraints:

    -231 <= numerator, denominator <= 231 - 1
    denominator != 0


 */
public class FractiontoRecurringDecimal166 {
    public String fractionToDecimal(int numerator, int denominator) {
        int sign = 1;
        if (numerator < 0 && denominator > 0 || numerator > 0 && denominator < 0) {
            sign = -1;
        }



        long num = Math.abs(Long.valueOf(numerator));
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
