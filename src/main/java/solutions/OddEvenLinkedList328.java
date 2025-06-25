package solutions;

/*
yandex
 */
public class OddEvenLinkedList328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null|| head.next == null || head.next.next == null) {
            return head;
        }

        ListNode endOdd = head;
        ListNode endEven = null;
        ListNode evenHead = null;
        ListNode even = head.next;
        ListNode odd = head.next.next;

        while (true) {
            endOdd.next = odd;
            endOdd = odd;
            if (endEven == null) {
                endEven = even;
                evenHead = even;
            } else {
                endEven.next = even;
                endEven = even;
            }

            if (odd.next == null || odd.next.next == null) {
                break;
            }

            even = odd.next;
            odd = odd.next.next;
        }

        if (odd.next != null) {
            even = odd.next;
            endEven.next = even;
            endEven = even;
        }

        endOdd.next = evenHead;
        endEven.next = null;

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
