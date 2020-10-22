package 链表;

/**
 * https://leetcode-cn.com/problems/palindrome-linked-list/
 *
 * @author CoderZk
 * @date 2020/10/22
 */
public class _234_回文链表 {
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        if (head.next.next == null) {
            return head.val == head.next.val;
        }


    }
}
