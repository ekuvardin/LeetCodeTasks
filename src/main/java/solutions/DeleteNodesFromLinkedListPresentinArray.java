package solutions;

import java.util.HashSet;
import java.util.Set;

/*
 DeleteNodesFromLinkedListPresentinArray deleteNodesFromLinkedListPresentinArray = new DeleteNodesFromLinkedListPresentinArray();

        DeleteNodesFromLinkedListPresentinArray.ListNode l1 = new DeleteNodesFromLinkedListPresentinArray.ListNode(1);
        DeleteNodesFromLinkedListPresentinArray.ListNode l2 = new DeleteNodesFromLinkedListPresentinArray.ListNode(2);
        DeleteNodesFromLinkedListPresentinArray.ListNode l3 = new DeleteNodesFromLinkedListPresentinArray.ListNode(3);
        DeleteNodesFromLinkedListPresentinArray.ListNode l4 = new DeleteNodesFromLinkedListPresentinArray.ListNode(4);
        DeleteNodesFromLinkedListPresentinArray.ListNode l5 = new DeleteNodesFromLinkedListPresentinArray.ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
 */
public class DeleteNodesFromLinkedListPresentinArray {

    public ListNode modifiedList(int[] nums, ListNode head) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }

        ListNode pointer = head;
        ListNode result = null;
        ListNode headResult = null;

        while (pointer != null) {
            if (!set.contains(pointer.val)) {
                if (result != null) {
                    result.next = new ListNode(pointer.val);
                    result = result.next;
                } else {
                    result = new ListNode(pointer.val);
                    headResult = result;
                }
            }
            pointer = pointer.next;
        }

        return headResult;
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
