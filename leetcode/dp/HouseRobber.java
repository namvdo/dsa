package leetcode.dp;

public class HouseRobber {
   public int rob(int[] nums) {
        int rob1 = 0;
        int rob2 = 0;
        for(int i = 0; i < nums.length; i++) {
            int tmp = Math.max(rob1 + nums[i], rob2);
            rob1 = rob2;
            rob2 = tmp;
        }
        return rob2;
    } 
}
