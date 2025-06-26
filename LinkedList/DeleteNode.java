// https://www.geeksforgeeks.org/in-a-linked-list-given-only-a-pointer-to-a-node-to-be-deleted-in-a-singly-linked-list-how-do-you-delete-it/

public class DeleteNode {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public void deleteNode(ListNode node) {
        if (node == null || node.next == null) return;

        node.val = node.next.val;          // Copy data from next node
        node.next = node.next.next;        // Bypass the next node
    }
    
}