package leetcode.string;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("V", 5);
        map.put("X", 10);
        map.put("L", 50);
        map.put("C", 100);
        map.put("D", 500);
        map.put("M", 1000);
        map.put("IV", 4);
        map.put("IX", 9);
        map.put("XL", 40);
        map.put("XC", 90);
        map.put("CD", 400);
        map.put("CM", 900);
        int p = s.length() - 1;
        if (s.length() == 1) {
            return map.get(s.charAt(0) + "");
        }
        int res = 0;
        int lastIdx = p;
        while (p > 0) {
            String sub = s.substring(p - 1, p + 1);
            if (map.containsKey(sub)) {
                lastIdx = p - 1;
                res += map.get(sub);
                p -= 2;
            } else {
                String x = s.substring(p, p + 1);
                res += map.get(x);
                lastIdx = p;
                p -= 1;
            }
        }
        if (lastIdx != 0) {
            res += map.get(s.charAt(0) + "");
        }
        return res;
    }
}
