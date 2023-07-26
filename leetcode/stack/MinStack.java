package leetcode.stack;

import java.util.Stack;

public class MinStack {
    Stack<Integer> stack = new Stack<>();
    Stack<Integer> minValues = new Stack<>();

    public void push(int x) {
        if (minValues.isEmpty() || x <= minValues.peek()) {
            minValues.push(x);
        }
        stack.push(x);
    }

    public void pop() {
        if (stack.peek().equals(minValues.peek())) {
            minValues.pop();
        }
        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValues.peek();
    }
}
