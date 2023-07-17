package leetcode.array;

public class TrappingRainingWater {
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int maxLeft = height[left], maxRight = height[right];
        int res = 0;
        while (left < right) {
            if (maxLeft < maxRight) {
                left += 1;
                maxLeft = Math.max(maxLeft, height[left]);
                res += maxLeft - height[left];
            } else {
                right -= 1;
                maxRight = Math.max(maxRight, height[right]);
                res += maxRight - height[right];
            }
        }
        return res;
    }
}
