package leetcode.stack;

import java.util.Stack;

public class SimplifyPath {

    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String cur = "";
        path = path + "/";
        for (int i = 0; i < path.length(); i++) {
            if (path.charAt(i) == '/') {
                if (cur.equals("..")) {
                    if (!stack.isEmpty()) {
                        stack.pop();
                    }
                } else if (!cur.equals("") && !cur.equals(".")) {
                    stack.push(cur);
                }
                cur = "";
            } else {
                cur += path.charAt(i);
            }
        }
        return "/" + String.join("/", stack);
    }
}
