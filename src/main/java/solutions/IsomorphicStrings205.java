package solutions;

import java.util.HashMap;
import java.util.Map;

/*
yandex

 IsomorphicStrings205 l = new IsomorphicStrings205();


        l.isIsomorphic("badc", "baba");
 */
public class IsomorphicStrings205 {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() == 1) {
            return true;
        }

        Map<Character, Character> mappedValues = new HashMap<>(28);
        Map<Character, Character> mappedValuesReversed = new HashMap<>(28);

        for (int i = 0; i < s.length(); i++) {
            if (mappedValues.get(s.charAt(i)) == null) {
                if (mappedValuesReversed.get(t.charAt(i)) == null) {
                    mappedValues.put(s.charAt(i), t.charAt(i));
                    mappedValuesReversed.put(t.charAt(i), s.charAt(i));
                } else {
                    return false;
                }
            } else {
                char mappedValue = mappedValues.get(s.charAt(i));
                if (mappedValue != t.charAt(i)) {
                    return false;
                }
            }
        }

        return true;
    }
}
