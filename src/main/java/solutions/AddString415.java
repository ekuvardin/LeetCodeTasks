package solutions;

/*
Given two non-negative integers, num1 and num2 represented as string, return the sum of num1 and num2 as a string.

You must solve the problem without using any built-in library for handling large integers (such as BigInteger). You must also not convert the inputs to integers directly.



Example 1:

Input: num1 = "11", num2 = "123"
Output: "134"

Example 2:

Input: num1 = "456", num2 = "77"
Output: "533"

Example 3:

Input: num1 = "0", num2 = "0"
Output: "0"



Constraints:

    1 <= num1.length, num2.length <= 104
    num1 and num2 consist of only digits.
    num1 and num2 don't have any leading zeros except for the zero itself.



avito
 */
public class AddString415 {
    public String addStrings(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        int aLen = num1.length();
        int bLen = num2.length();
        int value = 0;

        while (aLen > 0 || bLen > 0 || value == 1) {
            if (aLen > 0) {
                value = value + Character.getNumericValue(num1.charAt(aLen - 1));
                aLen--;
            }

            if (bLen > 0) {
                value = value + Character.getNumericValue(num2.charAt(bLen - 1));
                bLen--;
            }

            result.append(value % 10);
            value = value / 10;
        }

        return result.reverse().toString();
    }
}