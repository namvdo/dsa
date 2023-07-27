package leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class WordPattern {
    public boolean wordPattern(String pattern, String s) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> map2 = new HashMap<>();
        String[] str = s.split("\\s+");
        if (str.length != pattern.length())
            return false;
        for (int i = 0; i < pattern.length(); i++) {
            String p = pattern.charAt(i) + "";
            if (map.containsKey(p) && !map.get(p).equals(str[i])
                    || map2.containsKey(str[i]) && !map2.get(str[i]).equals(p)) {
                return false;
            }
            map.put(p, str[i]);
            map2.put(str[i], p);
        }
        return true;
    }
}
