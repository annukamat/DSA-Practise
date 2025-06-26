// https://www.geeksforgeeks.org/merge-sort-for-linked-list/
public class mergeSort {

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public ListNode mergeSort_(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode mid = findMid(head);
        ListNode left = head;
        ListNode right = mid.next;
        mid.next = null;

        left = mergeSort_(left);
        right = mergeSort_(right);

        return mergeTwoLists(left, right);
    }

    public ListNode findMid(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode slow = head, fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null || l2 == null) return l1 == null ? l2 : l1;

        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }

        prev.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }
}