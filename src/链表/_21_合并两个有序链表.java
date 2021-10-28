package 链表;

/**
 * https://leetcode-cn.com/problems/merge-two-sorted-lists/
 */
public class _21_合并两个有序链表 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newLinkedList = l1;
        ListNode p = l1;
        while (l1.next != null && l2.next != null) {
            if (l1.val > l2.val) {
                p = l2;
                l2 = l2.next;
            } else {
                p = l1;
                l1 = l1.next;
            }
            newLinkedList = p;
        }
        return newLinkedList;
    }
}
