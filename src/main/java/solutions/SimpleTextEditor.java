package solutions;

import java.util.Stack;

/*
    https://www.hackerrank.com/challenges/simple-text-editor/problem

            SimpleTextEditor simpleTextEditor = new SimpleTextEditor();

        Scanner in = new Scanner(System.in);
        int operationNumber = Integer.parseInt(in.nextLine());

        for (int i = 0; i < operationNumber; i++) {
            String value = in.nextLine();
            String[] values = value.split("\\s+");
            parseString(values, simpleTextEditor);
        }

/*
        String[] argss = new String[]{"1 abcde", "1 fg", "3 6", "2 5", "4 1", "3 7", "4 1", "3 4"};
        for (String arg : argss) {
            String[] values = arg.split("\\s+");
            parseString(values, simpleTextEditor);
        }*//*
    }

static private void parseString(String[] values, SimpleTextEditor simpleTextEditor) {
    switch (values[0]) {
        case "1":
            simpleTextEditor.append(values[1]);
            break;
        case "2":
            simpleTextEditor.delete(Integer.parseInt(values[1]));
            break;
        case "3":
            simpleTextEditor.print(Integer.parseInt(values[1]));
            break;
        case "4":
            simpleTextEditor.undo(1);
            break;
        default:
            break;
    }
}
 */
public class SimpleTextEditor {

    StringBuilder stringBuilder = new StringBuilder();
    Stack<Operation> stack = new Stack<Operation>();

    void append(String s) {
        stringBuilder.append(s);
        Operation operation = new Operation();
        operation.type = OperationType.ADD;
        operation.k = s.length();
        stack.add(operation);
    }

    void delete(int k) {
        int start = stringBuilder.length() - k;
        if (k > stringBuilder.length()) {
            start = 0;
        }

        String buf = stringBuilder.substring(start, stringBuilder.length());
        stringBuilder.delete(start, stringBuilder.length());

        Operation operation = new Operation();
        operation.type = OperationType.DELETE;
        operation.value = buf;
        stack.add(operation);
    }

    void print(int k) {
        if (k < 0 || k > stringBuilder.length()) {
            throw new RuntimeException("k in not in diapason");
        }

        System.out.println(stringBuilder.charAt(k - 1));
    }

    void undo(int k) {
        int idx = k;
        while (idx > 0 && !stack.isEmpty()) {
            Operation operation = stack.pop();

            if (operation.type == OperationType.ADD) {
                stringBuilder.delete(stringBuilder.length() - operation.k, stringBuilder.length());
            } else if (operation.type == OperationType.DELETE) {
                stringBuilder.append(operation.value);
            }

            idx--;
        }
    }

    static class Operation {
        OperationType type;
        String value;
        int k;
    }

    static enum OperationType {
        ADD,
        DELETE
    }
}
