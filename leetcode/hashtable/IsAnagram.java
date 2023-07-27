package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length())
            return false;
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            map.merge(c, 1, (x, y) -> x + y);
        }
        for (char c : t.toCharArray()) {
            if (!map.containsKey(c))
                return false;
            int count = map.get(c);
            if (count == 0)
                return false;
            count -= 1;
            map.put(c, count);
        }
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() != 0)
                return false;
        }
        return true;
    }
}
