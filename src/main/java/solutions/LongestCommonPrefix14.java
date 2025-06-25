package solutions;

import java.util.Arrays;

/*
yandex

"flower","flow","flight"
 */
public class LongestCommonPrefix14 {
    public String longestCommonPrefix(String[] strs) {
        String commonPart = "";

        if (strs.length == 0 || strs[0].isEmpty()) {
            return commonPart;
        }
        commonPart = strs[0];

        for (int i = 1; i < strs.length; i++) {
            String str = strs[i];
            if (str.isEmpty()) {
                return "";
            }

            if (str.length() < commonPart.length()) {
                commonPart = commonPart.substring(0, str.length());
            }

            StringBuilder preFix = new StringBuilder();
            for (int j = 0; j < str.length(); j++) {
                preFix.append(str.charAt(j));
                if (!commonPart.startsWith(preFix.toString())) {
                    if (j == 0) {
                        return "";
                    } else {
                        commonPart = commonPart.substring(0, j);
                    }
                    break;
                }
            }
        }

        return commonPart;
    }
}
