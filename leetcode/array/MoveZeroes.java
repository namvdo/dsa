package leetcode.array;

public class MoveZeroes {
    public void moveZeroes(int[] nums) {
        int curIdx = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                continue;
            } else {
                nums[curIdx] = nums[i];
                curIdx++;
            }
            
        }
        for(int i = curIdx; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
