package 链表;

import java.util.HashSet;
import java.util.Set;

/**
 * https://leetcode-cn.com/problems/intersection-of-two-linked-lists/
 *
 * @author CoderZk
 * @date 2020/10/22
 */
public class _160_相交链表 {
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        // 哈希集合 hashset
        if (headA == null || headB == null) return null;

        Set<ListNode> set = new HashSet<>();
        while (headA != null) {
            set.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (set.contains(headB)) {
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    // 双指针都走A + B的长度  我来到你的城市 走过你来时的路
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // O(n)
        if (headA == null || headB == null) return null;

        ListNode curA = headA, curB = headB;
        while (curA != curB) {
            curA = (curA == null) ? headB : curA.next;
            curB = (curB == null) ? headA : curB.next;

//            这段代码在两个链表不相交的时候会死循环
//            curA = (curA.next == null) ? headB : curA.next;
//            curB = (curB.next == null) ? headA : curB.next;
        }
        return curA;
    }
}
