package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class RemoveDuplicatedSorted {
    
    public ListNode deleteDuplicates(ListNode head) {
        ListNode cur = head;
        List<ListNode> nodes = new ArrayList<>();
        while (cur != null) {
            int c = duplicatedCount(cur);
            if (c == 1) {
                nodes.add(cur);
                cur = cur.next;
            } else {
                while (c-- != 0 && cur != null) {
                    cur = cur.next;
                }
            }
        }
        for (int i = 0; i < nodes.size(); i++) {
            ListNode node = nodes.get(i);
            node.next = null;
        }
        for (int i = 0; i < nodes.size() - 1; i++) {
            ListNode prev = nodes.get(i);
            ListNode next = nodes.get(i + 1);
            prev.next = next;
        }
        return nodes.isEmpty() ? null : nodes.get(0);
    }

    int duplicatedCount(ListNode node) {
        ListNode cur = node;
        int val = cur.val;
        int count = 1;
        while (cur.next != null) {
            cur = cur.next;
            if (cur.val == val) {
                count++;
            } else if (cur.val > val) {
                return count;
            }
        }
        return count;
    }
}
