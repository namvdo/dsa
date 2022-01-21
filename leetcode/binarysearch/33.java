class Solution {
    public int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low < high) {
            int mid = (low + high) / 2;
            if ((nums[mid] < nums[0]) == (target < nums[0])) {
                if (nums[mid] < target) {
                    low = mid + 1;
                } else if (nums[mid] > target) {
                    high = mid;
                } else return mid;
            } else if (target < nums[0]) low = mid + 1;
            else high = mid;
        } 
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.search(new int[] {4,5,6,7,0,1,2}, 0));
    }
}