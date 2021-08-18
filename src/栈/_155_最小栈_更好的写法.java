package 栈;

/**
 * @author CoderZk
 */
public class _155_最小栈_更好的写法 {

    // 只用一个栈(链表, 一样的, 栈本身就是用数组实现的)
    // 栈里面保存正常数值和最小值
    private static class Node {
        public int val;
        public int min;
        public Node next;

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }

    private Node head;

    public _155_最小栈_更好的写法() {
        head = new Node(0, Integer.MAX_VALUE, null);
    }

    public void push(int val) {
        head = new Node(val, Math.min(val, head.min), head);
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }
}
