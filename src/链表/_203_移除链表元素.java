package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) return null;
        while (head.val == val) {
            head = head.next;
            if (head == null) {
                return null;
            }
        }
        ListNode headNode = head;

        while (headNode.next != null) {
            if (headNode.next.val == val) {
                headNode.next = headNode.next.next;
            } else {
                headNode = headNode.next;
            }
        }
        return head;
    }
}
