package solutions;

public class RemoveDuplicates83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode current = head.next;
        int prev = head.val;
        ListNode prevNode = head;

        while (current != null) {
            if (current.val == prev) {
                prevNode.next = current.next;
            } else {
                prevNode = current;
                prev = current.val;
            }

            current = current.next;
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
