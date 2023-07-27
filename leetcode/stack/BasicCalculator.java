package leetcode.stack;

import java.util.Stack;

public class BasicCalculator {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int sign = 1;
        int cur = 0;
        int output = 0;
        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                cur = cur * 10 + Integer.parseInt(c + "");
            } else if (c == '+' || c == '-') {
                output += (cur * sign);
                cur = 0;
                if (c == '-') {
                    sign = -1;
                } else {
                    sign = 1;
                }
            } else if (c == '(') {
                stack.push(output);
                stack.push(sign);
                output = 0;
                sign = 1;
            } else if (c == ')') {
                output += (cur * sign);
                output *= stack.pop();
                output += stack.pop();
                cur = 0;
            }
        }
        return output + (cur * sign);
    }
}
