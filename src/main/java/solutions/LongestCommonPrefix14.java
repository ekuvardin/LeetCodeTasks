package solutions;

import java.util.Arrays;

/*
yandex

"flower","flow","flight"

Write a function to find the longest common prefix string amongst an array of strings.

If there is no common prefix, return an empty string "".



Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"

Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.


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
