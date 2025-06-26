// https://www.geeksforgeeks.org/remove-duplicates-from-an-unsorted-linked-list/

import java.util.HashSet;

public class RemoveDuplicatesUnsorted {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
    }

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) return null;

        HashSet<Integer> seen = new HashSet<>();
        ListNode current = head;
        ListNode prev = null;

        while (current != null) {
            if (seen.contains(current.val)) {
                // Duplicate: skip current node
                prev.next = current.next;
            } else {
                seen.add(current.val);
                prev = current;
            }
            current = current.next;
        }

        return head;
    }

    // Utility method to print linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " → ");
            head = head.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Example: 1 → 3 → 2 → 3 → 4 → 1
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(1);

        System.out.println("Original list:");
        printList(head);

        head = removeDuplicates(head);

        System.out.println("After removing duplicates:");
        printList(head);
    }
    
}
