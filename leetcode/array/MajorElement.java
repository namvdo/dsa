package leetcode.array;

public class MajorElement {
   public int majorElement(int[] nums)  {
        int count = 1;
        int majorIdx = 0;
        for(int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[majorIdx]) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    majorIdx = i;
                    count = 1;
                }
            }
        }
        return nums[majorIdx];
   }
}
