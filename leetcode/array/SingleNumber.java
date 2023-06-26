package leetcode.array;

public class SingleNumber {
   public int singleNumber(int[] nums) {
        int k = nums[0];
        for(int i = 1; i < nums.length; i++) {
            k ^= nums[i];
        }
        return k;
    } 
}
