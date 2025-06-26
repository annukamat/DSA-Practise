// https://www.geeksforgeeks.org/delete-nodes-which-have-a-greater-value-on-right-side/
public class deleteGreaterNode {

    public class ListNode {
        int data;
        ListNode next;
        ListNode(int data) {
            this.data = data;
        }
    }

    // Main function to delete nodes with greater value on the right
    public ListNode deleteNodes(Node head) {
        head = reverse(head);

        ListNode current = head;
        int max = current.data;

        while (current != null && current.next != null) {
            if (current.next.data < max) {
                current.next = current.next.next; // delete the node
            } else {
                current = current.next;
                max = current.data;
            }
        }

        return reverse(head); // reverse again to restore original order
    }

    // Function to reverse a linked list
    private Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }
        return prev;
    }
    
}
