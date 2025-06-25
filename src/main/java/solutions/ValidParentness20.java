package solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
yandex
 */
public class ValidParentness20 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> mapping = new HashMap<>();
        mapping.put(')', '(');
        mapping.put('}', '{');
        mapping.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            char val = s.charAt(i);
            if (mapping.containsValue(val)) {
                stack.push(s.charAt(i));
            } else if (mapping.containsKey(val)) {
                if (stack.isEmpty() || stack.pop() != mapping.get(val)) {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
