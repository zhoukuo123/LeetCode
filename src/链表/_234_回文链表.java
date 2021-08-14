package 链表;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author CoderZk
 * @date 2020/10/22
 */
public class _234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        // 时间复杂度O(n), 空间复杂度O(1)
        // 对称 -> 快慢指针找到中间节点
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }

        // 找到中间节点
        ListNode mid = middleNode(head);
        // 翻转右半部分(中间节点的右边部分)
        ListNode rHead = reverseList(mid.next);
        ListNode lHead = head;
        ListNode rOldHead = rHead;

        // 从lHead, rHead出发, 判断是否为回文链表
        boolean result = true;
        while (rHead != null) {
            if (rHead.val != lHead.val) {
                result = false;
                break;
            }
            rHead = rHead.next;
            lHead = lHead.next;
        }

        // 恢复右半部分(对右半部分再次翻转)
        reverseList(rOldHead);
        return result;
    }

    /**
     * 找到中间节点(右半部分链表头节点的前一个节点)
     * 比如 1>2>3>2>1中的3是中间节点
     * 比如 1>2>2>1中左边第一个2是中间节点
     */
    private ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }

    /**
     * 翻转链表
     *
     * @param head 原链表的头结点
     * @return 翻转之后链表的头结点
     */
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
}
