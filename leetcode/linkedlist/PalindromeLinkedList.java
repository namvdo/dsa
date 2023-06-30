package leetcode.linkedlist;

public class PalindromeLinkedList {
   public boolean isPalindrome(ListNode head) {
         ListNode fast = head;
         ListNode slow = head;
         while (fast != null && fast.next != null)  {
             fast = fast.next.next;
             slow = slow.next;    
         }
         if (fast != null && fast.next == null) {
             slow = slow.next;
         }
         ListNode node = reverse(slow);
         fast = head;
         while (node != null && fast != null) {
            int l = node.val;
            int r = fast.val;
            if (l != r) return false;
            node = node.next;
            fast = fast.next;
         }
         return true;
    }

    ListNode reverse(ListNode node) {
        ListNode prev = null;
        ListNode cur = node;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    } 
}
