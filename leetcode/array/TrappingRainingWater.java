package leetcode.array;

public class TrappingRainingWater {
    public int trap(int[] height) {
        int n = height.length;
        int[] maxLeft = new int[n];
        int[] maxRight = new int[n];
        for(int i = 1; i < n; i++) {
            maxLeft[i] = Math.max(height[i - 1], maxLeft[i - 1]);
        }

        for(int j = n - 2; j >= 0; j--) {
            maxRight[j] = Math.max(height[j + 1], maxRight[j + 1]);
        }

        int res = 0;
        for(int i = 0; i < n; i++) {
            int t = Math.min(maxLeft[i], maxRight[i]) - height[i];
            if (t > 0) {
                res += t;
            }
        }
        return res;
    }
}
