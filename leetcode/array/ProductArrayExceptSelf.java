package leetcode.array;

import java.util.Arrays;

public class ProductArrayExceptSelf {
   public int[] productExceptSelf(int[] nums) {
        int[] prefixes = new int[nums.length];
        Arrays.fill(prefixes, 1);
        for(int i = 1; i < nums.length; i++) {
            prefixes[i] *= prefixes[i - 1] * nums[i - 1];
        }
        int[] posfixes = new int[nums.length];
        Arrays.fill(posfixes, 1);
        for(int i = nums.length - 2; i >= 0; i--) {
            posfixes[i] *= posfixes[i + 1] * nums[i + 1];
        }
        int[] out = new int[nums.length];
        for(int i = 0; i < nums.length; i++) {
            out[i] = prefixes[i] * posfixes[i];
        }
        return out;
    }
}
