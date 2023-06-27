package leetcode.array;
import java.util.*;
public class TwoSum {
   public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> value2Index = new HashMap<>();
        for(int i = 0; i < nums.length; i++)  {
            int cur = nums[i];
            int left = target - cur;
            if (value2Index.get(left) != null) {
                return new int[] {i, value2Index.get(left)};
            } else {
                value2Index.put(cur, i);
            }
        }
        return new int[] {};
    } 
}
