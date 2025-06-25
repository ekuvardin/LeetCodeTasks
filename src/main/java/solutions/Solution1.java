package solutions;

import java.util.*;

class Solution1 {

    Queue<String> queue = new ArrayDeque<>();
    Set<String> visited = new HashSet<>();
    int step = 0;

    public int openLock(String[] deadends, String target) {
        visited.addAll(Arrays.asList(deadends));
        if(visited.contains("0000")){
            return -1;
        }

        queue.add("0000");
        visited.add("0000");



        while (!queue.isEmpty()) {
            int size = queue.size();

            while (size > 0) {
                String current = queue.poll();

                if (current.equals(target)) {
                    return step;
                }

                for (int i = 0; i < 4; i++) {
                    StringBuilder copy = new StringBuilder(current);
                    char x = copy.charAt(i);

                    copy.setCharAt(i, (copy.charAt(i) == '9' ? '0' : (char) (copy.charAt(i) + 1)));
                    String str = copy.toString();
                    if (!visited.contains(str)) {
                        visited.add(str);
                        queue.add(str);
                    }
                    copy = new StringBuilder(current);
                    copy.setCharAt(i, (copy.charAt(i) == '0' ? '9' : (char) (copy.charAt(i) - 1)));
                    str = copy.toString();
                    if (!visited.contains(str)) {
                        visited.add(str);
                        queue.add(str);
                    }

                }
                size--;
            }
            step++;
        }
        return -1;
    }
}
