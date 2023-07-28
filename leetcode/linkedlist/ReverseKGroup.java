package leetcode.linkedlist;

import java.util.ArrayList;
import java.util.List;

public class ReverseKGroup {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> nodes = getStartNodes(head, k);
        nodes.forEach(node -> System.out.println("node: " + node.val));
        List<ListNode> reversed = new ArrayList<>();
        for (ListNode node : nodes) {
            if (shouldReverse(node, k)) {
                reversed.add(reverse(node, k));
            } else {
                reversed.add(node);
            }
        }
        for (int i = 0; i < reversed.size() - 1; i++) {
            ListNode start = reversed.get(i);
            ListNode end = getLastNode(start, k);
            ListNode next = reversed.get(i + 1);
            end.next = next;
        }
        return reversed.get(0);
    }

    ListNode getLastNode(ListNode node, int k) {
        ListNode cur = node;
        while (cur.next != null && k != 0) {
            cur = cur.next;
            k--;
        }
        return cur;
    }

    ListNode reverse(ListNode start, int k) {
        ListNode prev = null;
        ListNode cur = start;

        while (cur != null) {
            if (k == 0)
                break;
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            k--;
        }
        return prev;
    }

    List<ListNode> getStartNodes(ListNode head, int k) {
        List<ListNode> nodes = new ArrayList<>();
        int idx = 0;
        ListNode cur = head;
        int size = size(head);
        while (cur != null) {
            if (idx % k == 0) {
                nodes.add(cur);
            }
            idx++;
            cur = cur.next;
        }
        return nodes;
    }

    int size(ListNode node) {
        int size = 0;
        ListNode cur = node;
        while (cur != null) {
            cur = cur.next;
            size++;
        }
        return size;
    }

    boolean shouldReverse(ListNode start, int k) {
        int c = 0;
        ListNode cur = start;
        while (cur != null) {
            cur = cur.next;
            c++;
            if (c >= k)
                return true;
        }
        return false;
    }

}
