package leetcode.hashtable;

public class IsHappy {
    public boolean isHappy(int n) {
        if (n <= 0)
            return false;
        int fast = digitSquaredSum(n);
        int slow = n;
        while (fast != 1 && slow != fast) {
            fast = digitSquaredSum(fast);
            fast = digitSquaredSum(fast);
            slow = digitSquaredSum(slow);
        }
        return fast == 1;
    }

    int digitSquaredSum(int n) {
        int sum = 0;
        while (n > 0) {
            int digit = n % 10;
            sum += digit * digit;
            n /= 10;
        }
        return sum;
    }
}
