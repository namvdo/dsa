package leetcode.string;

public class LongestPalidromeSubstring {
   public String longestPalindrome(String s) {
        String max = "";
        for(int i = 0; i < s.length(); i++) {
            String oddMax = longest(i, i, s);
            max = oddMax.length() > max.length() ? oddMax : max;
            String evenMax = longest(i, i + 1, s);
            max = evenMax.length() > max.length() ? evenMax : max;
        }
        return max;
    }

    String longest(int i, int j, String s) {
        for(; i >= 0 && j < s.length(); i--, j++) {
            if (s.charAt(i) != s.charAt(j)) break;
        }
        i++;
        j--;
        return s.substring(i, j + 1);
    } 
}
