package solutions;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class LinkedListCycle141 {


    public class Solution {
        public boolean hasCycle(ListNode head) {
            TreeSet<ListNode> set = new TreeSet<>((o1, o2) -> {
                if (o1 == o2) {
                    return 0;
                }

                if (o1.val <= o2.val) {
                    return -1;
                }

                return 1;
            });

            if (head == null) {
                return false;
            }

            ListNode curNode = head;

            while (curNode != null) {
                if (set.contains(curNode)) {
                    return true;
                } else {
                    set.add(curNode);
                }

                curNode = curNode.next;
            }

            return false;
        }
    }

    public boolean hasCycle2(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                return true;
            }
        }

        return false;
    }


    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
