package leetcode.linkedlist;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) return head;
        ListNode tail = head;
        int len = 1;
        while (tail.next != null) {
            tail = tail.next;
            len++;
        }
        k %= len; 
        if (k == 0) return head;
        int i = 0;
        ListNode cur = head;
        while (i < len - k - 1) {
            cur = cur.next;
        }
        ListNode newHead = cur.next;
        cur.next = null;
        tail.next = head;
        return newHead;
    }
 
}
