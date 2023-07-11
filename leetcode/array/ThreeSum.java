package leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            int f = 0;
            int s = 1;
            int t = nums.length - 1;
            while (f <= nums.length - 1) {
                int cur = nums[f];
                while (s < t) {
                    int second = nums[s];
                    int third = nums[t];
                    int rs = cur + second + third;
                    if (rs > 0) {
                        t--;
                    } else if (rs < 0) {
                        s++;
                    } else {
                        List<Integer> list = new ArrayList<>();
                        list.add(cur);
                        list.add(nums[s]);
                        list.add(nums[t]);
                        res.add(list);
                        while (s < nums.length && second == nums[s]) {
                            s++;
                        }
                        while (t > 0 && third == nums[t]) {
                            t--;
                        }
                    }
                }
                while (f < nums.length && nums[f] == cur) {
                    f++;
                }
                s = f + 1;
                t = nums.length - 1;
            }
            return res;
        }
    }
}
