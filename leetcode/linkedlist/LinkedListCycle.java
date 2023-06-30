package leetcode.linkedlist;

import java.util.*;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}

public class LinkedListCycle {
    public boolean hasCycle(ListNode head) {
        Map<ListNode, ListNode> map = new HashMap<>();
        ListNode cur = head;
        while (cur != null) {
            if (map.containsKey(cur))
                return true;
            map.put(cur, cur.next);
            cur = cur.next;
        }
        return false;
    }
}
