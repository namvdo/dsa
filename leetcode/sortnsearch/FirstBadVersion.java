package leetcode.sortnsearch;

public class FirstBadVersion {
   public int firstBadVersion(int n) {
        // if the current version is bad, then potentially there are some "previous" versions also bad
        // if the current version is not bad, then the left versions cannot be bad
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    } 
}
