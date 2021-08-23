package 链表;

/**
 * @author CoderZk
 */
public class _25_K个一组翻转链表_2 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {

        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode reverseKGroup(ListNode head, int k) {

        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;

        ListNode start = dummyHead;
        ListNode tail = head;

        while (tail != null) {
            int cnt = 0;
            while (cnt != k && tail != null) {
                cnt++;
                tail = tail.next;
            }

            if (cnt < k) {
                break;
            }

            ListNode tmp = start.next;
            reverse(start, tail);
            start = tmp;
        }

        return dummyHead.next;
    }

    private void reverse(ListNode head, ListNode tail) {
        // [head -> 1 -> 2 -> tail]

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
