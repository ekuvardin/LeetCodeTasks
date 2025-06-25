package solutions;

/*
   ReverseLinkedList206.ListNode l1 = new ReverseLinkedList206.ListNode(1);
        ReverseLinkedList206.ListNode l2 = new ReverseLinkedList206.ListNode(2);
        ReverseLinkedList206.ListNode l3 = new ReverseLinkedList206.ListNode(3);
        ReverseLinkedList206.ListNode l4 = new ReverseLinkedList206.ListNode(4);
        ReverseLinkedList206.ListNode l5 = new ReverseLinkedList206.ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;

        ReverseLinkedList206 reverseLinkedList206 = new ReverseLinkedList206();
        reverseLinkedList206.reverseList(l1);

        Yandex
 */
public class ReverseLinkedList206 {
    public ListNode reverseList(ListNode head) {
        ListNode hh = head;
        ListNode newListHead = head;

        if(hh == null || hh.next == null) {
            return head;
        }

        hh = hh.next;
        while(hh != null) {
            ListNode tmp = hh; // tmp = 2; hh = 2
            ListNode nextHead = hh.next; // nextHead = 3

            tmp.next = newListHead; // swap.next= 1
            newListHead = tmp; // newListHead = 2

            hh = nextHead; // hh =3
        }

        head.next = null;

        return newListHead;

    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}

