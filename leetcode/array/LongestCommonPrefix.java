package leetcode.array;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
       StringBuilder sb = new StringBuilder();
        int k = 0;
        int i = 0;
        int count = 0;
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        while (true) {
            if (k >= strs[i].length() || k >= strs[i + 1].length()) break;
            char c = strs[i].charAt(k);
            char n = strs[i + 1].charAt(k);
            if (c == n)
                count++;
            else break;
            if (count == strs.length) {
                k++;
                count = 0;
                sb.append(c);
                i = 0;
            } else if (i < strs.length - 2) {
                i++;
            } 
        }
        return sb.toString(); 
    }
}
