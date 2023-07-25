package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c : magazine.toCharArray()) {
            map.merge(c, 1, (x, y) -> x + y);
        }
        for(char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) == 0) return false;
            else {
                map.put(c, map.get(c) - 1);
            }
        } 
        return true;
    }
}
