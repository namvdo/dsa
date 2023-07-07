package leetcode.string;

public class MaxConsecutiveAnswer {
     public int maxConsecutiveAnswers(String answerKey, int k) {
        int f = 0, t = 0;
        int i = 0, j = 0;
        int res = 0;
        while (j < answerKey.length()) {
            if (answerKey.charAt(j) == 'F') f++;
            else t++;
            while (Math.min(f, t) > k) {
                if (answerKey.charAt(i) == 'F') f--;
                else t--;
                i++;
            }
            res = Math.max(res, f + t);
            j++;
        }
        return res;
    }
}
