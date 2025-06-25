package solutions;

import java.util.Stack;

public class Polish {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();

        for (String token : tokens) {
            if ((token.charAt(0) == '-' && token.length() > 1) || token.charAt(0) >= '0' && token.charAt(0) <= '9') {
                stack.push(Integer.valueOf(token));
            } else {
                int operand1 = stack.pop();
                int operand2 = stack.pop();
                switch (token) {
                    case "+":
                        stack.push(operand2 + operand1);
                        break;
                    case "-":
                        stack.push(operand2 - operand1);
                        break;
                    case "/":
                        stack.push(operand2 / operand1);
                        break;
                    case "*":
                        stack.push(operand2 * operand1);
                        break;
                }
            }
        }
        return stack.pop();
    }
}
