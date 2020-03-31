package 链表;

/**
 * https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list/
 */
public class _83_删除排序链表中的重复元素 {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode headNode = head;
        if (headNode == null) return null;
        while (headNode.next != null) {
            if (headNode.val == headNode.next.val) {
                headNode.next = headNode.next.next;
            } else {
                headNode = headNode.next;
            }
        }
        return head;
    }
}
