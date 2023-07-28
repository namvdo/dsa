package leetcode.linkedlist;

public class ReverseBetween {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int total = right - left + 1;
        if (total == 1)
            return head;
        ListNode leftNode = head;
        ListNode beforeLeft = null;
        int leftCount = 0;
        ListNode cur = head;

        while (cur != null) {
            leftCount++;
            if (leftCount == left) {
                leftNode = cur;
                break;
            }
            beforeLeft = cur;
            cur = cur.next;
        }

        cur = leftNode;
        int rightCount = 0;
        ListNode afterRight = null;
        ListNode rightNode = cur;
        while (cur != null) {
            rightCount++;
            if (rightCount == total) {
                rightNode = cur;
                afterRight = rightNode.next;
                break;
            }
            cur = cur.next;
        }
        ListNode prev = null;
        cur = leftNode;
        while (total > 0) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            total--;
        }

        if (beforeLeft != null) {
            beforeLeft.next = rightNode;
        } else {
            head = rightNode;
        }
        leftNode.next = afterRight;
        return head;
    }
}
