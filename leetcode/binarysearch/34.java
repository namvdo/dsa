import java.util.Arrays;

class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0 || nums.length == 1 && nums[0] != target)
            return new int[] { -1, -1 };
        int left = 0;
        int right = nums.length - 1;
        int idx = searchRange(nums, target, left, right);
        int leftIdx = searchRange(nums, target, left, idx, idx, true);
        int rightIdx = searchRange(nums, target, idx + 1, right, idx, false);
        return new int[] { leftIdx, rightIdx };
    }

    int searchRange(int[] nums, int target, int left, int right) {
        int mid = left + (right - left) / 2;
        if (left > right)
            return -1;
        if (nums[mid] == target)
            return mid;
        else if (nums[mid] > target)
            return searchRange(nums, target, left, mid - 1);
        else
            return searchRange(nums, target, mid + 1, right);
    }

    int searchRange(int[] nums, int target, int left, int right, int idx, boolean isLeft) {
        if (left > right)
            return idx;
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (isLeft) {
                return searchRange(nums, target, left, mid - 1, mid, isLeft);
            } else {
                return searchRange(nums, target, mid + 1, right, mid, isLeft);
            }
        } else if (nums[mid] < target)
            return searchRange(nums, target, mid + 1, right, idx, isLeft);
        else
            return searchRange(nums, target, left, mid - 1, idx, isLeft);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.searchRange(new int[] { 5, 7, 7, 8, 8, 10 }, 8)));
    }
}