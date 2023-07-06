package leetcode.string;

import java.util.HashSet;
import java.util.Set;

public class LengthOfLongestSubString {
   public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int left = 0, res = 0;
        for(int i = 0; i < s.length(); i++) {
            while (set.contains(s.charAt(i))) {
                set.remove(s.charAt(left));
                left += 1;
            }
            set.add(s.charAt(i));
            res = Math.max(res, i - left + 1);
        }
        return res;
    } 
}
