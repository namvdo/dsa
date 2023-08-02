package leetcode.graph;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class GeneticMutation {
    public int minMutation(String startGene, String endGene, String[] bank) {
        if (startGene.equals(endGene))
            return 0;
        Set<String> bankSet = new HashSet<>();
        for (String b : bank) {
            bankSet.add(b);
        }
        char[] charSet = new char[] { 'A', 'C', 'G', 'T' };
        int level = 0;
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(startGene);
        visited.add(startGene);

        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                String cur = queue.poll();
                if (cur.equals(endGene)) {
                    return level;
                }
                char[] curArray = cur.toCharArray();
                for (int i = 0; i < curArray.length; i++) {
                    char old = curArray[i];
                    for (char c : charSet) {
                        curArray[i] = c;
                        String next = new String(curArray);
                        if (!visited.contains(next) && bankSet.contains(next)) {
                            visited.add(next);
                            queue.offer(next);
                        }
                    }
                    curArray[i] = old;
                }
            }
            level++;
        }
        return -1;
    }
}
