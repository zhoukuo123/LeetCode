package 链表;

/**
 * https://leetcode-cn.com/problems/partition-list/
 *
 * @author CoderZk
 * @date 2020/10/22
 */
public class _86_分隔链表 {
    // 两个链表, 最终合并
    public ListNode partition2(ListNode head, int x) {

        if (head == null) {
            return null;
        }

        ListNode lHead = new ListNode(0);
        ListNode lTail = lHead;
        ListNode rHead = new ListNode(0);
        ListNode rTail = lHead;
        ListNode cur = null;
        int flag = 0;

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
        lTail.next = rHead.next;

        return lHead.next;
    }


    public ListNode partition(ListNode head, int x) {
        // 时间复杂度O(n)
        // 空间复杂度O(1)
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
