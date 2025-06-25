package solutions;

import java.util.*;

class Solution {

    Queue<List<Integer>> queue;
    Queue<Integer> queueStep;
    Set<List<Integer>> visited;

    public int openLock1(String[] deadends, String target) {
        List<Integer> init = new ArrayList<>(Collections.nCopies(4, 0));

        List<Integer> finalTarget = new ArrayList<>(4);

        for (int i = 0; i < 4; i++) {
            finalTarget.add(Integer.valueOf(String.valueOf(target.charAt(i))));
        }

        visited = new HashSet<>();
        for (String deadend : deadends) {
            List<Integer> cur = new ArrayList<>(4);
            for (int i = 0; i < 4; i++) {
                cur.add(Integer.valueOf(String.valueOf(deadend.charAt(i))));
            }
            visited.add(cur);
        }

        if (visited.contains(init))
            return -1;

        int steps = 0;

        queue = new ArrayDeque<>();
        queueStep = new ArrayDeque<>();
        queue.add(init);
        queueStep.add(0);
        visited.add(init);

        while (!queue.isEmpty()) {

            List<Integer> current = queue.poll();
            steps = queueStep.poll();

            if (equalsList(current, finalTarget)) {
                return steps;
            }
            for (int i = 0; i < 4; i++) {
                List<Integer> val = moveForward(current, i, steps);
                if (equalsList(val, finalTarget)) {
                    return steps + 1;
                }
                val = moveBackWard(current, i, steps);
                if (equalsList(val, finalTarget)) {
                    return steps + 1;
                }
            }
        }

        return -1;
    }

    private List<Integer> moveForward(List<Integer> current, int i, int steps) {
        List<Integer> currentState = new ArrayList<>(current);
        currentState.set(i, (current.get(i) + 1) % 10);

        if (!visited.contains(currentState)) {
            queue.add(currentState);
            visited.add(currentState);
            queueStep.add(steps + 1);
        }
        return currentState;
    }

    private List<Integer> moveBackWard(List<Integer> current, int i, int steps) {
        List<Integer> currentState = new ArrayList<>(current);
        currentState.set(i, (current.get(i) + 10 - 1) % 10);
        if (!visited.contains(currentState)) {
            queue.add(currentState);
            visited.add(currentState);
            queueStep.add(steps + 1);
        }
        return currentState;
    }

    private boolean equalsList(List<Integer> a1, List<Integer> a2) {
        for (int i = 0; i < 4; i++) {
            if (!a1.get(i).equals(a2.get(i))) {
                return false;
            }
        }

        return true;
    }
}
