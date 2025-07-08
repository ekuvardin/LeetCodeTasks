package solutions;

public class StringAtoI8 {
    public int myAtoi(String s) {
        String val = s.trim();

        if(val.isEmpty()) {
            return 0;
        }

        int signed = 1;
        int idx = 0;

        if (val.charAt(0) == '-') {
            signed = -1;
            idx = 1;
        } else if (val.charAt(0) == '+') {
            idx = 1;
        }

        StringBuilder builder = new StringBuilder();

        for (; idx < val.length(); idx++) {
            int temp = val.charAt(idx) - '0';
            if (temp >= 0 && temp <= 9) {
                builder.append(temp);
            } else {
                break;
            }
        }

        if (builder.length() == 0) {
            return 0;
        }

        if (signed == -1) {
            builder.insert(0, "-");
        }

        String result = builder.toString();


        int r;
        try {
            r = Integer.parseInt(result);
        } catch (NumberFormatException e) {
            if(signed == -1) {
               r = Integer.MIN_VALUE;
            } else {
                r = Integer.MAX_VALUE;
            }
        }

        return  r;
    }
}
