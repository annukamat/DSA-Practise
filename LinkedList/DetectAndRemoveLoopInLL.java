// https://www.geeksforgeeks.org/detect-and-remove-loop-in-a-linked-list/

public class DetectAndRemoveLoopInLL {

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void removeLoop(ListNode head) {
        if (head == null) return;

        ListNode sp = startingPoint(head);
        if (sp == null) return; // No loop

        ListNode temp = sp;
        while (temp.next != sp) {
            temp = temp.next;
        }

        temp.next = null; // break the loop
    }

    public static ListNode startingPoint(ListNode head) {
        if (head == null) return null;

        ListNode slow = head, fast = head;

        // Detect cycle
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Find start of the loop
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }

        return null;
    }
}
