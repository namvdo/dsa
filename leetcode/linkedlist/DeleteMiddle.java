package leetcode.linkedlist;

public class DeleteMiddle {
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = new ListNode(0, head);
        if (head.next == null)
            return null;
        ListNode fast = head;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        slow.next = slow.next.next;
        return head;
    }
}
