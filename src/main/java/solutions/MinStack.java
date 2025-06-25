package solutions;

import java.util.*;

public class MinStack {
    List<Pair> data;

    public MinStack() {
        data = new ArrayList<>();
    }

    public void push(int val) {
        if (data.isEmpty()) {
            data.add(new Pair(val,val));
        } else {
            int min = data.get(data.size() - 1).minValue;
            data.add(new Pair(val, Math.min(val, min)));
        }

    }

    public void pop() {
        data.remove(data.size() - 1);
    }

    public int top() {
        return data.get(data.size() - 1).value;
    }

    public int getMin() {
        return data.get(data.size() - 1).minValue;
    }

    class Pair {
        int value, minValue;
        public Pair(int value, int minValue) {
            this.value = value;
            this.minValue = minValue;
        }
    }
}

