package leetcode.string;

public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        s = String.join("", s.toLowerCase().split("[^A-Za-z0-9]"));
        for(int i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) return false;
        }
        return true;
    } 
}
