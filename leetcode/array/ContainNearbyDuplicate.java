package leetcode.array;

import java.util.HashMap;
import java.util.Map;

public class ContainNearbyDuplicate {
   public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            Integer idx = map.remove(nums[i]);
            if (idx != null && Math.abs(i - idx) <= k) {
                return true;
            } 
            map.put(nums[i], i);
        }
        return false;
    } 
}
