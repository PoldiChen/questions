package question005;

import java.util.Stack;

/**
 * @author poldi.chen
 * @className StackWithMin
 * @description 另外维护一个最小值的栈
 * @date 2019/3/17 11:17
 **/
public class StackWithMin {

    private Stack<Integer> dataStack = new Stack<>();
    private Stack<Integer> minStack = new Stack<>();

    private void pushWithMin(int num) {
        dataStack.push(num);
        if (minStack.size() == 0 || minStack.peek() >= num) {
            minStack.push(num);
        } else {
            minStack.push(minStack.peek());
        }
    }

    private void popWithMin() {
        if (dataStack.size() > 0 && minStack.size() > 0) {
            dataStack.pop();
            minStack.pop();
        }
    }

    private int getMin() {
        return minStack.peek();
    }

    public static void main(String[] args) {
        StackWithMin stack = new StackWithMin();
        stack.pushWithMin(4);
        stack.pushWithMin(2);
        stack.pushWithMin(3);
        System.out.println(stack.getMin());
        stack.pushWithMin(1);
        System.out.println(stack.getMin());
        stack.popWithMin();
        System.out.println(stack.getMin());
    }

}
