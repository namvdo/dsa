package leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneNumberCombination {
    public List<String> letterCombinations(String digits) {
        Map<String, String> map = new HashMap<>();
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        List<String> res = new ArrayList<>();
        if (!digits.isEmpty()) {
            backtrack(0, digits, "", res, map);
        }
        return res;
    }


    void backtrack(int i, String digits, String cur, List<String> res, Map<String, String> map) {
        if (cur.length() == digits.length()) {
            res.add(cur);
            return;
        }
        String digit = String.valueOf(digits.charAt(i));
        char[] letters = map.get(digit).toCharArray();
        for(char c : letters) {
            backtrack(i + 1, digits, cur + c, res, map);
        }
    }
}
