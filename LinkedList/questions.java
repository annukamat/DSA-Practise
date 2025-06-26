import java.util.*;

public class questions {

    // First Non Repeating Character in a stream
    public static String FirstNonRepeating(String A){
        int n = A.length();
        HashMap<Character, Integer> map = new HashMap<>();
        Queue<Character> que = new LinkedList<>();
        StringBuilder ans = new StringBuilder();

        for(int i=0; i<n; i++){
            char ch = A.charAt(i);
            if(!map.containsKey(ch)){
                map.put(ch, 1);
                que.add(ch);
            }else{
                map.put(ch, map.get(ch)+1);
            }

            while(que.size()!=0 && map.get(que.peek())>1) que.remove();

            if(que.size()==0) ans.append("#");
            else ans.append(que.peek());
        }

        return ans.toString();
    }

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

    // Merge two bottom-linked sorted lists
    Node merge(Node a, Node b) {
        if (a == null) return b;
        if (b == null) return a;

        Node result;

        if (a.data < b.data) {
            result = a;
            result.bottom = merge(a.bottom, b);
        } else {
            result = b;
            result.bottom = merge(a, b.bottom);
        }

        return result;
    }

    // Main flatten function
    Node flatten(Node root) {
        if (root == null || root.next == null)
            return root;

        // Recurse on next
        root.next = flatten(root.next);

        // Merge current and next
        root = merge(root, root.next);

        // Set next to null as we only use bottom
        root.next = null;

        return root;
    }
}


    public static void main(String[] args) {
        
    }
}