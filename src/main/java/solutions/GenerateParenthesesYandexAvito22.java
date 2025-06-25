package solutions;

import java.util.*;

public class GenerateParenthesesYandexAvito22 {
    public List<String> generateParenthesis(int n) {
        List<String> retValues = new ArrayList<>();
        generateParentnes("", n * 2, 0, 0, retValues);
        return retValues;
    }

    private static void generateParentnes(String value, int len, int closed, int opened, List<String> retValues) {
        if (closed == opened && closed == len / 2) {
            retValues.add(value);
            return;
        }

        if (closed < len / 2 && opened > closed) {
            generateParentnes(value + ")", len, closed+1, opened, retValues);
        }

        if(opened < len/2 && opened >= closed) {
            generateParentnes(value + "(", len, closed, opened + 1, retValues);
        }
    }


}
