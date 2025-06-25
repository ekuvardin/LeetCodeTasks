package solutions;

import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char value : s.toCharArray()) {
            if(value == '{') {
                stack.push('}');
            } else if (value == '(') {
                stack.push(')');
            }else if (value == '[') {
                stack.push(']');
            } else if(stack.isEmpty() ||  stack.pop() != value) {
                return false;
            }
        }

        return stack.isEmpty();
    }
}
