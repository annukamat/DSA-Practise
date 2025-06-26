class Node {
    int data;
    Node next;
    Node bottom;

    Node(int data) {
        this.data = data;
        next = null;
        bottom = null;
    }
}

public class FlattenLinkedList {

    // Main flatten function
    Node flatten(Node root) {
        if(root==null || root.next == null) return root;

        root.next = flatten(root.next);

        root = merge(root, root.next);
        root.next = null;

        return root;
    }

    // Merge two bottom-linked sorted lists
    Node merge(Node a, Node b) {
        if(a==null || b==null) return (a==null) ? a : b;

        Node res;
        if(a.data < b.data){
            res = a;
            res.bottom = merge(res.bottom, b);
        }else{
            res = b;
            res.bottom = merge(a, res.bottom);
        }
        return res;
    }
}

