package leetcode.linkedlist;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class CopyListWithRandomPointers {
    public Node copyRandomList(Node head) {
        // old to new
        Map<Node, Node> oldToNew = new HashMap<>();
        Node cur = head;
        while (cur != null) {
            Node newNode = new Node(cur.val);
            oldToNew.put(cur, newNode);
            cur = cur.next;
        }
        cur = head;
        while (cur != null) {
            Node newNode = oldToNew.get(cur);
            newNode.next = oldToNew.get(cur.next);
            newNode.random = oldToNew.get(cur.random);
            cur = cur.next;
        }
        return oldToNew.get(head);
    }
}
