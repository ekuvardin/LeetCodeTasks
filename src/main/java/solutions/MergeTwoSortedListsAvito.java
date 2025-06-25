package solutions;

/*
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.

Return the head of the merged linked list.



Example 1:

Input: list1 = [1,2,4], list2 = [1,3,4]
Output: [1,1,2,3,4,4]

Example 2:

Input: list1 = [], list2 = []
Output: []

Example 3:

Input: list1 = [], list2 = [0]
Output: [0]



Constraints:

    The number of nodes in both lists is in the range [0, 50].
    -100 <= Node.val <= 100
    Both list1 and list2 are sorted in non-decreasing order.


 */
public class MergeTwoSortedListsAvito {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode next1 = list1;
        ListNode next2 = list2;

        ListNode prev = null;
        ListNode result = null;

        while (next1 != null && next2 != null) {
            ListNode currentNode;
            if (next1.val <= next2.val) {
                currentNode = new ListNode(next1.val);
                next1 = next1.next;
            } else {
                currentNode = new ListNode(next2.val);
                next2 = next2.next;
            }

            if (prev == null) {
                result = currentNode;
            } else {
                prev.next = currentNode;
            }
            prev = currentNode;
        }

        ListNode next = next1 == null ? next2 : next1;

        while (next != null) {
            ListNode currentNode = new ListNode(next.val);
            if (prev == null) {
                result = currentNode;
            } else {
                prev.next = currentNode;
            }

            prev = currentNode;
            next = next.next;
        }

        return result;
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
