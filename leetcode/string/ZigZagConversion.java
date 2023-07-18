package leetcode.string;

public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 1)
            return s;
        String res = "";
        for (int r = 0; r < numRows; r++) {
            int increment = 2 * (numRows - 1);
            for (int k = r; k < s.length(); k += increment) {
                res += s.charAt(k);
                if (r > 0 && r < numRows - 1 && k + increment - 2 * r < s.length()) {
                    res += s.charAt(k + increment - 2 * r);
                }
            }
        }
        return res;
    }
}
