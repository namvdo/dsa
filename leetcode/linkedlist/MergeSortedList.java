package leetcode.linkedlist;

public class MergeSortedList {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode out = new ListNode(-999); // create a dummy node
        ListNode head = out;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                out.next = list1;
                list1 = list1.next;
            } else {
                out.next = list2;
                list2 = list2.next;
            }
            out = out.next;
        }
        if (list1 != null) {
            out.next = list1;
        }
        if (list2 != null) {
            out.next = list2;
        }
        return head.next;
    }
}
