package solutions;

/*
yandex
 */
public class MaximumDifferenceRemappingDigit2566 {

    public int minMaxDifference(int num) {
        StringBuilder val = new StringBuilder();
        val.append(num);

        char startChar = val.charAt(0);


        int i = 1;
        while (i < val.length() && val.charAt(i) == startChar) {
            i++;
        }

        //99932488
        long min = 0;
        long max;
        if (i == val.length()) {
            max = Long.parseLong(val.toString().replace(startChar, '9'));
        } else {
            val.delete(0, i);
            min = Long.parseLong(val.toString().replace(startChar, '0'));

            if(startChar != '9') {
                String v = "9";
                v = v.repeat(i);
                max = Long.parseLong(v + val.toString().replace(startChar, '9'));
            } else {
                val = new StringBuilder();
                val.append(num);
                max = Long.parseLong(val.toString().replace(val.charAt(i), '9'));
            }
        }

        return (int) (max - min);
    }


}
