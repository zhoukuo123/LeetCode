package 栈;

import java.util.Stack;

/**
 * @author CoderZk
 */
public class _155_最小栈 {

    // 用来存放正常数据
    private Stack<Integer> stack;
    // 用来存放最小数据
    private Stack<Integer> minStack;


    public _155_最小栈() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minStack.isEmpty()) {
            minStack.push(val);
        } else {
            minStack.push(Math.min(val, minStack.peek()));
//            if (val < minStack.peek()) {
//                minStack.push(val);
//            } else {
//                minStack.push(minStack.peek());
//            }
        }
    }

    public void pop() {
        stack.pop();
        minStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
