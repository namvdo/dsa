package leetcode.array;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 0;
        for(int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (i == digits.length - 1) ? digits[i] + 1 : digits[i] + carry;
            if (digits[i] % 10 == 0 && digits[i] != 0) {
                carry = 1;
                digits[i] = 0;
            } else {
                carry = 0;
            }  
            if (digits[i] == 0 && i == 0 && carry == 1) {
                int[] arr = new int[digits.length + 1];
                int k = 0;
                for(int x = 1; x < arr.length; x++, k++) {
                    arr[x] = digits[k];
                }     
                arr[0] = 1;
                return arr;
            }
        }
        return digits;
    }
}