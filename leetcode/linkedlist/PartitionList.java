package leetcode.linkedlist;

public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode leftTail = left;
        ListNode rightTail = right; 

        while (head != null) {
            int val = head.val;
            if (val < x) {
                leftTail.next = head;
                leftTail = leftTail.next;
            } else {
                rightTail.next = head;
                rightTail = rightTail.next;
            }
            head = head.next;
        }
        leftTail.next = right.next;
        rightTail.next = null;
        return left.next;
    }
}
