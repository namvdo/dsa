package leetcode.string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class IntToRoman {
    public String intToRoman(int num) {
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
        LinkedHashMap<String, Integer> newMap = map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(new Comparator<>() {
                    public int compare(Integer a, Integer b) {
                        return -1 * a.compareTo(b);
                    }
                }))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        int left = num;
        StringBuilder sb = new StringBuilder();
        while (left != 0) {
            for (Map.Entry<String, Integer> entry : newMap.entrySet()) {
                if (entry.getValue() <= left) {
                    left -= entry.getValue();
                    sb.append(entry.getKey());
                    break;
                }
            }
        }
        return sb.toString();
    }
}
