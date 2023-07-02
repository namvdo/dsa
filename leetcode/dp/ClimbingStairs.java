package leetcode.dp;

public class ClimbingStairs {

   public int climbStairs(int n) {
        int one = 1;
        int two = 1;
        for(int i = 0; i < n - 1; i++) {
            int tmp = one;
            one += two;
            two = tmp;
        }
        return one;
   }  
}
