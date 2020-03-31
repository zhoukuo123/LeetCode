package 链表;

/**
 * https://leetcode-cn.com/problems/middle-of-the-linked-list/
 */
public class _876_链表的中间结点 {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        int flag = 0;
        while (fast != null && fast.next != null && fast.next.next != null ) {
            flag = 1;
            fast = fast.next.next;
            slow = slow.next;
        }
        if (flag == 0 && fast == null) {
            head = slow;
        } else {
            head = slow.next;
        }
        return head;
    }
}
