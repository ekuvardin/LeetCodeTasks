package solutions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

/*
yandex
 */
public class MergekSortedLists23 {
    public ListNode mergeKLists(ListNode[] lists) {

        if (lists.length == 0) {
            return null;
        }

        if (lists.length == 1) {
            return lists[0];
        }

        TreeMap<Integer, List<ListNode>> map = new TreeMap<>();

      /*  TreeSet<ListNode> set = new TreeSet<>((o1, o2) -> {
            if (o1 == o2) {
                return 0;
            }
            if (o1.val <= o2.val) {
                return -1;
            }

            return 1;

        });*/

        for (ListNode list : lists) {
            if (list != null) {
                List<ListNode> lt = map.computeIfAbsent(list.val, k -> new ArrayList<>());
                lt.add(list);
            }
        }

        ListNode head = null;
        ListNode tail = null;

        while (!map.isEmpty()) {
            Map.Entry<Integer, List<ListNode>> lt = map.firstEntry();

            ListNode newNode = lt.getValue().get(lt.getValue().size() - 1);
            lt.getValue().remove(lt.getValue().size() - 1);
            if(lt.getValue().isEmpty()) {
                map.remove(lt.getKey());
            }

            if (head == null) {
                head = newNode;
            } else {
                tail.next = newNode;
            }
            tail = newNode;

            if (newNode.next != null) {
                List<ListNode> lt1 = map.computeIfAbsent(newNode.next.val, k -> new ArrayList<>());
                lt1.add(newNode.next);
            }
        }

        if (tail != null) {
            tail.next = null;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
