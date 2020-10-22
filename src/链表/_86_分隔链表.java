package 链表;

/**
 * https://leetcode-cn.com/problems/partition-list/
 *
 * @author CoderZk
 * @date 2020/10/22
 */
public class _86_分隔链表 {
    public ListNode partition(ListNode head, int x) {
        // O(n)
        if (head == null) return null;
        ListNode lHead = new ListNode(0);
        ListNode lTail = lHead;
        ListNode rHead = new ListNode(0);
        ListNode rTail = rHead;
        while (head != null) {
            if (head.val < x) {
                lTail.next = head;
                lTail = head;
            } else {
                rTail.next = head;
                rTail = head;
            }
            head = head.next;
        }
        rTail.next = null;
        // 拼接
        lTail.next = rHead.next;
        return lHead.next;
    }
}
