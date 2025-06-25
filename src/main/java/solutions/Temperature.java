package solutions;

import java.util.Stack;

class Temperature {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] result = new int[temperatures.length];
        Stack<Pair> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty()) {
                Pair stackValue = stack.peek();
                if (temperatures[i] > stackValue.value) {
                    result[stackValue.position] = i - stackValue.position;
                    stack.pop();
                } else {
                    break;
                }
            }

            stack.push(new Pair(temperatures[i], i));
        }

        return result;
    }

    public class Pair {
        int value;
        int position;

        public Pair(int value, int position) {
            this.value = value;
            this.position = position;
        }
    }
}
