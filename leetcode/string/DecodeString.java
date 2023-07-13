package leetcode.string;

import java.util.Stack;

public class DecodeString {
    public String decodeString(String s) {
        Stack<String> chars = new Stack<>();
        Stack<Integer> nums = new Stack<>();
        // whenever encounter a ]
        char[] input = s.toCharArray();
        int i = 0;
        String res = "";

        while (i < input.length) {
            if (Character.isDigit(input[i])) {
                int num = 0;
                while (Character.isDigit(input[i])) {
                    num = num * 10 + (input[i] - '0');
                    i += 1;
                }
                nums.push(num);
            } else if (input[i] == ']') {
                int count = nums.pop();
                StringBuilder sb = new StringBuilder(chars.pop());
                for(int j= 0; j < count; j++) {
                    sb.append(res);
                }
                res = sb.toString();
                i += 1;
            } else if (input[i] == '[') {
                chars.push(res);
                res = "";
                i += 1;
            } else {
                res += input[i];
                i += 1;
            }
        }
        return res;
    } 
}
