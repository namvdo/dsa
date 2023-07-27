package leetcode.stack;

import java.util.Stack;

public class ReversePolishNotation {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                int x = stack.pop();
                int y = stack.pop();
                int res;
                if (token.equals("+")) {
                    res = y + x;
                } else if (token.equals("-")) {
                    res = y - x;
                } else if (token.equals("*")) {
                    res = y * x;
                } else {
                    res = y / x;
                }
                stack.push(res);
            } else {
                stack.push(Integer.parseInt(token));
            }
        }
        return stack.pop();
    }
}
