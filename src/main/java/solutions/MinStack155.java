package solutions;

import java.util.HashMap;
import java.util.Stack;
import java.util.TreeMap;

public class MinStack155 {
    Stack<Keys> stack;

    public MinStack155() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if(stack.isEmpty()) {
            stack.push(new Keys(val, val));
        } else {
            int minVal = Math.min(val, stack.peek().min);
            stack.push(new Keys(val, minVal));
        }
    }

    public void pop() {
        stack.pop();
    }

    public int top() {
        return stack.peek().value;
    }

    public int getMin() {
        return stack.peek().min;
    }

    static class Keys {
        int value;
        int min;

        public Keys(int value, int min) {
            this.value = value;
            this.min = min;
        }
    }
}
