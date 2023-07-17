package leetcode.greedy;

import java.util.Arrays;

public class Candy {
    public int candy(int[] ratings) {
        int rs[] = new int[ratings.length];
        Arrays.fill(rs, 1);
        for(int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                rs[i] = Math.max(rs[i - 1] + 1, rs[i]);
            }
        }

        for(int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                rs[i] = Math.max(rs[i + 1] + 1, rs[i]);
            }
        }

        int x = 0;
        for(int e : rs) {
            x += e;
        }
        return x;
    }
}
