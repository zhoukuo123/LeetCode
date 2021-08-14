package 链表;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author CoderZk
 * @date 2020/10/22
 */
public class _234_回文链表2 {
    public boolean isPalindrome(ListNode head) {
        // 时间复杂度O(n), 空间复杂度O(1)
        // 对称 -> 快慢指针找到中间节点
        if (head.next == null || head == null) {
            return true;
        }

        if (head.next.next == null) {
            if (head.val == head.next.val) {
                return true;
            }
        }

        ListNode middleNode = middleNode(head);
        ListNode rHead = reverseList(middleNode.next);
        ListNode lHead = head;
        while (rHead != null) {
            if (lHead.val != rHead.val) {
                return false;
            }
            lHead = lHead.next;
            rHead = rHead.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        while (head != null) {
            ListNode tmp = head.next;
            head.next = newHead;
            newHead = head;
            head = tmp;
        }
        return newHead;
    }

    private ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}
