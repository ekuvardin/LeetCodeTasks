package solutions;

public class AddStringAvito {
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