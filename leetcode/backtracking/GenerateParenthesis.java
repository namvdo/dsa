package leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

public class GenerateParenthesis {
   public List<String> generateParenthesis(int n) {
        Stack<Character> stack = new Stack<>();
        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, stack, res);
        return res;
    }

    void backtrack(int openN, int closedN, int n, Stack<Character> stack, List<String> res) {
        if (openN == closedN && closedN == n) {
            res.add(stack.stream().map(e -> e + "").collect(Collectors.joining()));
            return;
        }

        if (openN < n) {
            stack.push('(');
            backtrack(openN + 1, closedN, n, stack, res);
            stack.pop();
        }

        if (closedN < openN) {
            stack.push(')');
            backtrack(openN, closedN + 1, n, stack, res);
            stack.pop();
        }
    } 
}
