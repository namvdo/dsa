package leetcode.array;

import java.math.BigInteger;
class Solution {
   public int myAtoi(String s) {
        if (s == null || s.isBlank()) return 0;
        boolean isPositive = true;
        StringBuilder num = new StringBuilder();
        if (!acceptedChars(s.charAt(0))) return 0;
        boolean hasDigit = Character.isDigit(s.charAt(0)); 
        if (hasDigit) {
            num.append(s.charAt(0));
        }
        if ('-' == s.charAt(0)) {
            isPositive = false;
        }
        for(int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (acceptedChars(c)) {
                if (hasDigit && isNonDigit(c)) {
                    break;
                } 
                hasDigit = Character.isDigit(c);
                if (hasDigit) {
                    num.append(c);
                }
                if (c == '-') {
                    isPositive = false;
                }
                if (hasSign(c) && hasSign(s.charAt(i - 1))) return 0;
                if (hasSign(s.charAt(i - 1)) && isNonDigit(c)) return 0;
            } else{
                break;
            }
        }
        if (num.isEmpty()) return 0;
        BigInteger bi = new BigInteger(num.toString());
        if (!inRangeLong(bi, isPositive)) {
            if (isPositive) return Integer.MAX_VALUE; 
            else {
                return Integer.MIN_VALUE;
            }
        } 
        long tmp = 0;
        long multiplier = 1;
        for(int i = num.length() - 1; i >= 0; i--) {
            String ch = num.charAt(i) + "";
            int digit = Integer.parseInt(ch);
            tmp += multiplier * digit;
            multiplier *= 10;
        }
        if (inRange(tmp)) {
           return isPositive ? (int) tmp : (int) (-1 * tmp);
        } else {
            if (isPositive) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        }
    }

    boolean inRangeLong(BigInteger num, boolean isPositive) {
        if (isPositive) {
            BigInteger max = BigInteger.valueOf(Long.MAX_VALUE);
            BigInteger curNum = num;
            return curNum.compareTo(max) <= 0;
        } else {
            BigInteger max = BigInteger.valueOf(Long.MIN_VALUE);
            BigInteger curNum = num; 
            return curNum.compareTo(max) >= 0;
        }

    }
    
    boolean isNonDigit(char c) {
        return !Character.isDigit(c);
    }
    
    boolean hasSign(char c) {
        return c == '-' || c == '+';
    }
    
    boolean signOrSpace(char c) {
        return hasSign(c) || c == ' ';
    }
    
    boolean acceptedChars(char c) {
        return c == ' ' || Character.isDigit(c) || c == '+' || c == '-';
    }
    
    boolean inRange(long val) {
        return val <= Integer.MAX_VALUE && val >= Integer.MIN_VALUE;
    } 
}
