// https://www.geeksforgeeks.org/find-a-triplet-from-three-linked-lists-with-sum-equal-to-a-given-number/

public class tripletSum {

    public class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }

    // Reverse a linked list
    public Node reverse(Node head) {
        Node prev = null;
        while (head != null) {
            Node next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    // Sort linked list using merge sort
    public Node sortList(Node head) {
        if (head == null || head.next == null) return head;

        Node mid = getMiddle(head);
        Node midNext = mid.next;
        mid.next = null;

        Node left = sortList(head);
        Node right = sortList(midNext);

        return merge(left, right);
    }

    public Node getMiddle(Node head) {
        Node slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public Node merge(Node a, Node b) {
        Node dummy = new Node(0), tail = dummy;
        while (a != null && b != null) {
            if (a.data < b.data) {
                tail.next = a;
                a = a.next;
            } else {
                tail.next = b;
                b = b.next;
            }
            tail = tail.next;
        }
        tail.next = (a != null) ? a : b;
        return dummy.next;
    }

    // Main triplet check function
    public boolean isTripletPresent(Node head1, Node head2, Node head3, int target) {
        if (head2 == null || head3 == null || head1 == null) return false;
        
        head2 = sortList(head2);
        head3 = sortList(head3);
        head3 = reverse(head3);
        Node a = head1;

        while(a != null){
            Node b=head2, c=head3;
            while(b!=null && c!=null){
                int sum = a.data + b.data + c.data;

                if(sum == target) return true;
                else if(sum < target) b = b.next;
                else c = c.next;
            }
            a = a.next;
        }
        return false;
    }
}
