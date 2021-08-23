package 链表;

/**
 * @author CoderZk
 */
public class _25_K个一组翻转链表 {
    public ListNode reverseKGroup(ListNode head, int k) {
        // 特殊情况直接返回
        if (head == null || head.next == null || k == 1) {
            return head;
        }

        // 会修改head所以要先定义dummy节点
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        // start 和 tail 是开区间，start和tail内的节点需要颠倒，但是不包括start和tail
        ListNode tail = head;
        ListNode start = dummyHead;

        // 开始循环直到尾巴为null
        while (tail != null) {
            // 记录是否到达k了
            int cnt = 0;
            while (cnt < k && tail != null) {
                tail = tail.next;
                cnt++;
            }

            // tail为null但是cnt没数到k个, 不反转
            if (cnt < k) {
                break;
            }

            ListNode tmp = start.next; // 保存一下下一次的头, 注意: 后面已经翻转完毕, start.next就是应该的位置
            reverseList(start, tail); // 反转
            start = tmp; // 移动start
        }

        return dummyHead.next;
    }

    private void reverseList(ListNode head, ListNode tail) {
        // 反转head, tail之内的元素
        // head -> 3 -> 2 -> 1 -> tail

        if (head == tail || head.next == tail) {
            return;
        }

        ListNode p1 = head.next;
        ListNode p2 = head.next.next;
        while (p2 != tail && p2 != null) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }

        head.next.next = tail;
        head.next = p1;
    }

    private void reverseList2(ListNode head, ListNode tail) {
        // 反转head, tail之内的元素
        // head -> 3 -> 2 -> 1 -> tail
        if (head == tail || head.next == tail) {
            return;
        }
        ListNode p1 = head.next;
        ListNode p2 = head.next.next;
        while (p2 != null && p2 != tail) {
            ListNode tmp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = tmp;
        }
        head.next.next = tail;
        head.next = p1;
    }


}
