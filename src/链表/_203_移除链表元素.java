package 链表;

/**
 * https://leetcode-cn.com/problems/remove-linked-list-elements/
 */
public class _203_移除链表元素 {
    public ListNode removeElements(ListNode head, int val) {
        // 时间复杂度O(n)
        // 空间复杂度O(1)
        // 添加虚拟头结点
        if (head == null) {
            return null;
        }

        ListNode newHead = new ListNode(0);
        ListNode newTail = newHead;

        while (head != null) {
            if (head.val != val) {
                newTail.next = head;
                newTail = head;
            }
            head = head.next;
        }
        newTail.next = null;
        return newHead.next;

    }

    public ListNode removeElements2(ListNode head, int val) {
        // 时间复杂度O(n)
        // 未添加虚拟头结点
        // 新链表的头结点
        ListNode newHead = null;
        // 新链表的尾结点
        ListNode newTail = null;

        while (head != null) {
            if (head.val != val) {
                if (newTail == null) {
                    newHead = newTail = head;
                } else {
                    newTail.next = head;
                    newTail = head;
                }
            }
            head = head.next;
        }
        if (newTail == null) {
            return null;
        } else {
            newTail.next = null;
        }
        return newHead;
    }

    public ListNode removeElements3(ListNode head, int val) {
        // O(n)
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
