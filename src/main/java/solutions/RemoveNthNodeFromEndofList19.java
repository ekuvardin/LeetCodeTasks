package solutions;

/*
yandex
 */

public class RemoveNthNodeFromEndofList19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int count = 1;
        ListNode cur = head;
        while (cur.next != null) {
            count++;
            cur = cur.next;
        }

        if (n == count) {
            return head.next;
        }

        int skip = count - n;
        cur = head;

        while (skip - 1 > 0) {
            cur = cur.next;
            skip--;
        }

        cur.next = cur.next.next;

        return head;
    }

    public class ListNode {
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
