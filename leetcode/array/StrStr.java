package leetcode.array;

public class StrStr {
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;
        int len = haystack.length();
        int nlen = needle.length();
        int c = 0;
        int k = 0;
        int x = 0;
        while (x < len) {
            boolean found = false;
            for(int j = 0; j < needle.length(); j++) {
                char h = x < len ? haystack.charAt(x) : '\0';
                char n = needle.charAt(j);
                if (n == h) {
                    c++;   
                    x++;
                } else {
                    c = 0;
                    x++;
                    break;
                }
                if (c == nlen) {
                    found = true;
                    break;
                }
            }
            if (found) {
                return x - nlen;
            }
            k += 1;
            x = k;
        }
        return -1;
    }
}
