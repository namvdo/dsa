package leetcode.linkedlist;

public class SwapNodeInPair {
   public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(-1, head);
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null) {
            ListNode nextPair = cur.next.next;
            ListNode second = cur.next;

            second.next = cur;
            cur.next = nextPair;
            prev.next = second;

            prev = cur;
            cur = nextPair;
        }
        return dummy.next;
    } 
}
