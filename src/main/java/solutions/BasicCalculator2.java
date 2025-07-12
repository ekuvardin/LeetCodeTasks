package solutions;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/*
yandex

        BasicCalculator2 l = new BasicCalculator2();
       // l.calculate(new String("1*2-3/4-26"));
       l.calculate1(new String("282-1*2*13-30"));
 */
public class BasicCalculator2 {

    public int calculate1(String s) {
        String val = s.trim();

        int curentNum = 0;
        ArrayDeque<Integer> values = new ArrayDeque<>();
        ArrayDeque<Character> operation = new ArrayDeque<>();

        for (int i = 0; i < val.length(); i++) {
            char curChar = val.charAt(i);

            if (curChar >= '0' && curChar <= '9') {
                curentNum = curentNum * 10 + (curChar - '0');
            }

            if (curChar == '+' || curChar == '-' || curChar == '/' || curChar == '*') {

                if (!operation.isEmpty()) {
                    char prevChar = operation.peek();
                    if (prevChar == '*') {
                        operation.pop();
                        int vals = values.pop();
                        values.push(vals * curentNum);
                    } else if (prevChar == '/') {
                        operation.pop();
                        int vals = values.pop();
                        values.push(vals / curentNum);
                    } else if (prevChar == '+' && (curChar == '-' || curChar == '+')) {
                        operation.pop();
                        int vals = values.pop();
                        values.push(vals + curentNum);
                    } else if (prevChar == '-' && (curChar == '-' || curChar == '+')) {
                        operation.pop();
                        int vals = values.pop();
                        values.push(vals - curentNum);
                    } else {
                        values.push(curentNum);
                    }
                } else {
                    values.push(curentNum);
                }

                operation.push(curChar);
                curentNum = 0;
            }
        }

        if (!operation.isEmpty()) {
            char prevChar = operation.pop();
            if (prevChar == '*') {
                int vals = values.pop();
                values.push(vals * curentNum);
            } else if (prevChar == '/') {
                int vals = values.pop();
                values.push(vals / curentNum);
            } else if (prevChar == '+') {
                int vals = values.pop();
                values.push(vals + curentNum);
            } else if (prevChar == '-') {
                int vals = values.pop();
                values.push(vals - curentNum);
            } else {
                values.push(curentNum);
            }
        } else {
            return curentNum;
        }

        int res = values.pollLast();

        while(!operation.isEmpty()) {
            int vals = values.pollLast();
            char opeartion = operation.pollLast();
            if(opeartion == '+') {
                res += vals;
            } else {
                res -= vals;
            }
        }

        return res;

    }

    public int calculate(String s) {
        Stack<Integer> st = new Stack<>();

        int num = 0;
        char operator = '+';

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            }

            if (isOperator(c) || i == s.length() - 1) {
                if (operator == '+') st.push(num);
                else if (operator == '-') st.push(-num);
                else if (operator == '*') st.push(st.pop() * num);
                else if (operator == '/') st.push(st.pop() / num);

                num = 0;
                operator = c;
            }
        }

        int ans = 0;

        while (!st.isEmpty()) {
            ans += st.pop();
        }

        return ans;
    }

    private boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }
}
