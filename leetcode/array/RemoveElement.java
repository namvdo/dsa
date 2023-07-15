package leetcode.array;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (val == nums[i]) {
                for (int k = i; k < len - 1; k++) {
                    nums[k] = nums[k + 1];
                }
                len--;
                i--;
            }
        }
        return len;
    }
}
