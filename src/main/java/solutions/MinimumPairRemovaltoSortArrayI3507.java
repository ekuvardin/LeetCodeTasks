package solutions;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.TreeSet;

public class MinimumPairRemovaltoSortArrayI3507 {

    Node minSorted = null;

    public static class Node {
        int start;
        long sum;
        long valueLeft;
        long valueRight;
        Node next;
        Node prev;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return start == node.start;
        }

        @Override
        public int hashCode() {
            return Objects.hash(start);
        }

        public Node(int start, int valueLeft, int valueRight) {
            this.start = start;
            this.sum = valueLeft + valueRight;
            this.valueLeft = valueLeft;
            this.valueRight = valueRight;
        }
    }


    public int minimumPairRemoval(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }

        TreeSet<Node> set = new TreeSet<>((o1, o2) -> {
            if (o1.sum == o2.sum) {
                return Long.compare(o1.start, o2.start);
            }

            return Long.compare(o1.sum, o2.sum);
        });


        Node first = null;
        Node prev = null;

        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                continue;
            }
            Node node = new Node(i, nums[i - 1], nums[i]);

            if (prev != null) {
                prev.next = node;
                node.prev = prev;


            } else {
                first = node;
            }

            prev = node;
            set.add(node);
        }

        int count = 0;

        while (!isSorted(first) && !set.isEmpty()) {
            Node minNode = set.first();
            set.remove(minNode);

            // 0 + 1          0 + (1+2)
            // 1 + 2    1
            // 2 + 3    2      (1+2), 3
            if (minNode.prev != null) {
                prev = minNode.prev;
                set.remove(prev);
                minNode.prev.sum += minNode.valueRight;
                minNode.prev.valueRight = minNode.sum;
                minNode.prev.next = minNode.next;
                set.add(prev);

                if(minNode == minSorted) {
                    minSorted = minNode.prev;
                }
            } else {
                minSorted = minNode.next;
            }

            if (minNode.next != null) {
                Node next = minNode.next;
                set.remove(next);
                next.start = minNode.start;
                minNode.next.sum += minNode.valueLeft;
                minNode.next.valueLeft = minNode.sum;
                minNode.next.prev = minNode.prev;
                set.add(next);
            }

            if (minNode == first) {
                first = minNode.next;
            }

            count++;
        }

        if (first != null) {
            if (first.valueLeft > first.valueRight) {
                count++;
            }
        }

        return count;
    }


    private boolean isSorted(Node first) {
        Node temp = minSorted == null ? first : minSorted;
        while (temp != null) {
            if (temp.valueLeft <= temp.valueRight) {
                minSorted = temp;
            } else {
                return false;
            }
            temp = temp.next;
        }

      /*  Node temp = first;
        while (temp != null) {
            if (temp.valueLeft > temp.valueRight) {
                return false;
            }
            temp = temp.next;
        }*/

        return true;
    }
}
