package leetcode.greedy;

public class CanCompleteCircuit {

    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasSum = 0;
        for (int i = 0; i < gas.length; i++) {
            gasSum += gas[i];
        }
        int costSum = 0;
        for (int i = 0; i < cost.length; i++) {
            costSum += cost[i];
        }
        if (gasSum < costSum)
            return -1;
        int res = 0, total = 0;
        for (int i = 0; i < gas.length; i++) {
            total += (gas[i] - cost[i]);
            if (total < 0) {
                total = 0;
                res = i + 1;
            }
        }
        return res;
    }

}
